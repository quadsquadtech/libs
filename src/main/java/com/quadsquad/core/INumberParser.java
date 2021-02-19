package com.quadsquad.core;

public class INumberParser {

    private INumberParser() {
    }

    public static int parseInt(String s) {

        if (s == null) s = "";

        s = s.trim();
        if (s.isEmpty()) return 0;

        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return 0;
        }
    }
    
    public static double parseDouble(String s) {

        if (s == null) s = "";

        s = s.trim();
        if (s.isEmpty()) return 0;

        try {
            return Double.parseDouble(s);
        } catch (Exception e) {
            return 0;
        }
    }

    public static boolean isNumber(String s) {

        if (s == null) s = "";

        s = s.trim();
        if (s.isEmpty()) return false;

        try {
             Integer.parseInt(s);
             return true ;
        } catch (Exception e) {
            return false;
        }
    }
}
