package com.quadsquad.core.utils;


import java.lang.reflect.Field;

public class FieldAccessor {

    private FieldAccessor() {
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

    public static Field getField(Class<?> clazz, String propertyName) throws NoSuchFieldException {

        Class<?> aClass = clazz;

        Field field = null;

        NoSuchFieldException ex = null;
        while (field == null) {

            try {
                field = aClass.getDeclaredField(propertyName);
            } catch (NoSuchFieldException e) {

                ex = e;
                if (aClass.isAssignableFrom(Object.class)) {
                    break;
                }
                aClass = aClass.getSuperclass();
            }
        }

        if (field == null) {
            throw ex;
        }

        return field;
    }
}
