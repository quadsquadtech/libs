package com.quadsquad.core;


import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public class IEmpty {

    private IEmpty() {
    }

    public static boolean isEmpty(Object obj) {

        if (obj == null) {
            return true;
        }

        if (obj instanceof Optional) {
            return !((Optional) obj).isPresent();
        }
        if (obj instanceof CharSequence) {
            return ((CharSequence) obj).length() == 0;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj) == 0;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }

        return false;
    }

    public static boolean isEmpty(Object[] array) {
        return (array == null || array.length == 0);
    }

}
