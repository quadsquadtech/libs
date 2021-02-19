package com.quadsquad.core.utils;

import java.util.Base64;

public class Base64Converter {

    private static final String UTF = "UTF-8";

    private Base64Converter() {
    }

    public static String encode(String string) {

        try {

            byte[] bytes = string.getBytes(UTF);
            return Base64.getEncoder().encodeToString(bytes);

        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] decode(String string) {
        return Base64.getDecoder().decode(string);
    }
}
