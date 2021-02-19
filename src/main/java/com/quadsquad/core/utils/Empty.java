package com.quadsquad.core.utils;


public class Empty {

    private static final String EMPTY_STRING = "" ;

    private Empty() {
    }

    public static <T> T ofNull() {
        return null ;
    }

    public static String ofEmpty() {
        return EMPTY_STRING ;
    }

    public static boolean isEmpty(String string) {
        return string == null || string.trim().isEmpty()  ;

    }
    public static boolean isNull(Object object) {
        return object == null ;
    }

}
