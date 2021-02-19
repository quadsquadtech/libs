package com.quadsquad.core.application;

import com.quadsquad.core.IEmpty;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class ICoreContainer {

    private final Map<String, Object> keyValues = new HashMap();


    public final List<Object> registeredInstances() {

        Set<Object> set = new LinkedHashSet<>() ;
        for (String hashCode : keyValues.keySet()) {

            set.add(keyValues.get(hashCode)) ;
        }

        return new ArrayList<>(set) ;
    }

    public <T> T getBean(Class<T> requiredType) {

        final T o = (T) getInstance(requiredType);

        return o ;
    }

    public final void registerInstances(Collection<Class<?>> clazz) {

        if (IEmpty.isEmpty(clazz)) {
            return;
        }

        for (Class<?> c : clazz) {

            if (c != null) {
                registerInstance(c);
            }
        }
    }

    public boolean isInterface(Class<?> clazz) {
        return clazz.isInterface() ;
    }

    public final Object getInstance(Class<?> clazz) {

        if (clazz == null) return null;

        final String className = getClassNameOf(clazz) ;

        Object object = keyValues.get(className) ;
        if (object != null) return object ;

        if (isInterface(clazz)) {

            for (String key : keyValues.keySet()) {

                final Object object_ = keyValues.get(key) ;

                if (isAssignableFrom(object_, clazz)) {
                    object = object_ ;
                    return object;
                }
            }
        }

        final Class[] interfaces = clazz.getInterfaces();
        if (IEmpty.isEmpty(interfaces)) {

            for (String key : keyValues.keySet()) {

                final Object object_ = keyValues.get(key) ;

                if (clazz.isAssignableFrom(object_.getClass())) {
                    object = object_ ;
                    return object;
                }
            }
        }

        for (String key : keyValues.keySet()) {

            final Object object_ = keyValues.get(key) ;

            if (isAssignableFrom(object_, interfaces)) {
                object = object_ ;
            }
        }

        return object ;
    }


    private boolean isAssignableFrom(Object object, Class[] interfaces) {

        for (int i = 0; i < interfaces.length; i++) {

            if (!object.getClass().isAssignableFrom(interfaces[i])) {
                return false ;
            }
        }

        return true ;
    }

    private boolean isAssignableFrom(Object object, Class interface_) {
        return interface_.isAssignableFrom(object.getClass()) ;
    }

    public final void registerInstance(Class<?> clazz) {

        if (clazz == null) return;

        try {

            Object obj = null;

            final String className = getClassNameOf(clazz) ;

            if (keyValues.get(className) != null) {
                return;
            }

            Constructor<?> ctor = clazz.getDeclaredConstructors()[0];
            ctor.setAccessible(true);
            obj = ctor.newInstance();

            registerInstance(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void registerInstances(Object... objects) {

        if (objects == null) return;

        for (Object object : objects) {

            if (object != null) {
                final String className = getClassNameOf(object.getClass()) ;
                keyValues.put(className, object) ;
            }
        }
    }

    public final void registerInstance(Object obj) {

        if (obj == null) return;
        final String className = getClassNameOf(obj.getClass()) ;

        try {

            keyValues.put(className, obj) ;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getClassNameOf(Class<?> clazz) {
        return clazz.getName() ;
    }
}
