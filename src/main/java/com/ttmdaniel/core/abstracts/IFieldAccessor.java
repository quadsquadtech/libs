package com.ttmdaniel.core.abstracts;


import java.lang.reflect.Field;

public class IFieldAccessor {

    private IFieldAccessor() {
    }

    public static String getStaticValue(Class<?> cls, String fieldName) {

        try {
            Field f = getField(cls, fieldName);
            f.setAccessible(true);
            return (String) f.get(null);

        } catch (Exception e) {
            return null;
        }
    }

    public static Field getField(Class<?> _class, String propertyName) throws NoSuchFieldException {

        Class<?> aClass = _class;

        Field field = null;

        NoSuchFieldException e_ = null;
        while (field == null) {

            try {
                field = aClass.getDeclaredField(propertyName);
            } catch (NoSuchFieldException e) {

                e_ = e;
                if (aClass.isAssignableFrom(Object.class)) {
                    break;
                }
                aClass = aClass.getSuperclass();
            }
        }

        if (field == null) {
            throw e_;
        }

        return field;
    }
}
