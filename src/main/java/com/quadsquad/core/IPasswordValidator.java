package com.quadsquad.core;

public class IPasswordValidator {

    private static final int MIN_LENGTH = 8 ;
    private static final int MAX_LENGTH = 24 ;

    private IPasswordValidator() {}

    public static boolean isValid(String password) {

        if (IEmpty.isEmpty(password)) return false ;
        if (!((password.length() >= MIN_LENGTH) && (password.length() <= MAX_LENGTH))) return false;
        if (password.contains(" ")) return false;

        int count = 0;

//        for (int i = 0; i <= 9; i++) {
//
//            String str1 = Integer.toString(i);
//
//            if (password.contains(str1)) {
//                count = 1;
//            }
//        }
//        if (count == 0) {
//            return false;
//        }

//        if (!
//                (password.contains("@") || password.contains("#")
//                || password.contains("!") || password.contains("~")
//                || password.contains("$") || password.contains("%")
//                || password.contains("^") || password.contains("&")
//                || password.contains("*") || password.contains("(")
//                || password.contains(")") || password.contains("-")
//                || password.contains("+") || password.contains("/")
//                || password.contains(":") || password.contains(".")
//                || password.contains(", ") || password.contains("<")
//                || password.contains(">") || password.contains("?")
//                || password.contains("|"))) {
//            return false;
//        }

//        if (true) {
//            int count = 0;
//
//            // checking capital letters
//            for (int i = 65; i <= 90; i++) {
//
//                // type casting
//                char c = (char)i;
//
//                String str1 = Character.toString(c);
//                if (password.contains(str1)) {
//                    count = 1;
//                }
//            }
//            if (count == 0) {
//                return false;
//            }
//        }

//        if (true) {
//            int count = 0;
//
//            // checking small letters
//            for (int i = 90; i <= 122; i++) {
//
//                // type casting
//                char c = (char)i;
//                String str1 = Character.toString(c);
//
//                if (password.contains(str1)) {
//                    count = 1;
//                }
//            }
//            if (count == 0) {
//                return false;
//            }
//        }

        // if all conditions fails
        return true;
    }
}
