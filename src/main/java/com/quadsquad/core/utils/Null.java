package com.quadsquad.core.utils;

public final class Null {

    private Null() { }

    public static  <T> T of(Class<T> clazz) {
        return ConstructorUtil.newInstanceOf(clazz) ;
    }
}
