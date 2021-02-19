package com.quadsquad.core.utils;

import java.lang.reflect.Constructor;

public class ConstructorUtil {

    private ConstructorUtil() {}

    public static <T> T newInstanceOf(Class<T> clazz) {

        try {

            Constructor<?> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true) ;
            return (T) constructor.newInstance();

        } catch (Exception e) {
            return null ;
        }
    }
}
