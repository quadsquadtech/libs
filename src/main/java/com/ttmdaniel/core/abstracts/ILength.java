package com.ttmdaniel.core.abstracts;

public class ILength {

    private ILength() {
    }

    public static boolean isEquals(String string, int length) {

        if (string == null || string.trim().isEmpty()) return false;
        return string.length() == length;
    }

    public static boolean isGreaterThan(String string, int length) {

        if (string == null || string.trim().isEmpty()) return false;
        return string.length() > length;
    }

    public static boolean isLessThan(String string, int length) {

        if (string == null || string.trim().isEmpty()) return false;
        return string.length() < length;
    }

    public static boolean isGreaterThanOrEquals(String string, int length) {

        if (string == null || string.trim().isEmpty()) return false;
        return string.length() >= length;
    }

    public static boolean isLessThanOrEquals(String string, int length) {

        if (string == null || string.trim().isEmpty()) return false;
        return string.length() <= length;
    }
}
