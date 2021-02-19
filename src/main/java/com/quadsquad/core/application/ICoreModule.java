package com.quadsquad.core.application;

import com.quadsquad.core.ICoreModuleContext;
import com.quadsquad.core.IEmpty;
import com.quadsquad.core.IReactiveChain;
import com.quadsquad.core.annotations.ICoreInitialize;
import com.quadsquad.core.annotations.ICoreInject;
import com.quadsquad.core.annotations.ICoreInjectable;
import com.quadsquad.core.annotations.ICoreSequence;
import com.quadsquad.core.requestprocessing.IGenericExecutionException;
import com.quadsquad.core.requestprocessing.IGenericExecutionProcessor;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.scanners.TypeElementsScanner;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class ICoreModule implements ICoreModuleContext {

    private ICoreContainer coreContainer ;


//    private ICoreModule() {
//    }

    public static <T extends ICoreModule> T initialize(Class<T> primarySource, Object... args) throws IGenericExecutionException {

        if (primarySource == null) {
            throw new IGenericExecutionException("null primarySource") ;
        }

        if (primarySource.getSimpleName().equals(ICoreModule.class.getSimpleName())) {
            throw new IGenericExecutionException("ICoreModule not acceptable") ;
        }

        final Reflections reflections = ReflectionUtil.getReflection(
                primarySource.getPackage().getName(),
                new TypeElementsScanner() ,
                new TypeAnnotationsScanner(),
                new MethodAnnotationsScanner() ,
                new FieldAnnotationsScanner() ,
                new SubTypesScanner(false ),
                new ResourcesScanner()
        ) ;

        final ICoreContainer coreContainer = new ICoreContainer() ;

        coreContainer.registerInstances(args);

        final Set<Class<?>> injectables = collectInjectables(reflections) ;
        coreContainer.registerInstances(injectables);

        final Set<Class<?>> sequences = collectSequences(reflections) ;
        createSequences(sequences, coreContainer);

        final List<Object> registeredInstances = coreContainer.registeredInstances() ;

        for (Object object : registeredInstances) {

            final List<Field> fields = collectInjectablesFields(object) ;
            if (!IEmpty.isEmpty(fields)) {
                inject(fields, object, coreContainer);
            }
        }

        for (Object object : registeredInstances) {
            initializeObjects(object);
        }

        final T application = coreContainer.getBean(primarySource) ;

        ((ICoreModule) application).coreContainer = coreContainer ;

        return application ;
    }

    private static Set<Class<?>> collectSequences(Reflections reflections) {
        return reflections.getTypesAnnotatedWith(ICoreSequence.class);
    }

    private static Set<Class<?>> collectInjectables(Reflections reflections) {
        return reflections.getTypesAnnotatedWith(ICoreInjectable.class);
    }

    private static List<Field> collectInjectablesFields(Object obj) {

        final List<Field> fields = new ArrayList<>() ;

        for (Field field : obj.getClass().getDeclaredFields()) {

            if (field.isAnnotationPresent(ICoreInject.class)) {

                field.setAccessible(true);
                fields.add(field) ;
            }
        }

        return fields ;
    }

    private static void inject(List<Field> fields, Object object , ICoreContainer coreContainer) {

        for (Field field : fields) {

            Class<?> clazz = field.getType() ;
            Object value = coreContainer.getInstance(clazz) ;

            if (value != null) {

                try {
                    field.set(object, value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void createSequences(Collection<Class<?>> clazz, ICoreContainer coreContainer) {

        if (IEmpty.isEmpty(clazz)) {
            return;
        }

        for (Class<?> c : clazz) {

            if (c != null && c.isAnnotationPresent(ICoreSequence.class)) {

                ICoreSequence annotation = c.getAnnotation(ICoreSequence.class);

                Class<? extends IReactiveChain.IChainNode<?>>[] sequence = annotation.sequence() ;

                if (!IEmpty.isEmpty(sequence)) {
                    createSequence(c, sequence, coreContainer);
                }
            }
        }
    }

    private static void createSequence(Class<?> claz, Class<? extends IReactiveChain.IChainNode<?>>[] sequence, ICoreContainer coreContainer) {

        Object obj = coreContainer.getInstance(claz) ;

        if (obj != null) {

            IGenericExecutionProcessor p = (IGenericExecutionProcessor)obj ;
            if (p == null) return;

            final List<IReactiveChain.IChainNode<?>> list = new ArrayList<>() ;
            for (Class<? extends IReactiveChain.IChainNode<?>> aClass : sequence) {

                if (!aClass.isAssignableFrom(ICoreSequence.DefaultChain.class)) {

                    IReactiveChain.IChainNode<?> chainNode = coreContainer.getBean(aClass);
                    if (chainNode != null) {
                        list.add(chainNode);
                    }
                }
            }

            if (list.size() > 0) {
                try {
                    p.addScenes(list) ;
                } catch (IGenericExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void initializeObjects(Object object) {

        for (Method method : object.getClass().getDeclaredMethods()) {

            method.setAccessible(true);
            if (method.isAnnotationPresent(ICoreInitialize.class)) {

                try {
                    method.invoke(object) ;
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public <T> T getBean(Class<T> requiredType) {
        return coreContainer.getBean(requiredType);
    }
}

