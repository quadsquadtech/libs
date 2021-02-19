package com.ttmdaniel.core.abstracts;

import java.util.Base64;

public class StringUtil {

    private static final String UTF = "UTF-8";

    private StringUtil() {
    }

    public static String getSubstring(String string, int fromIndex, int toLength) {

        try {

            if (string == null) return "";

            String s = string.trim();
            if (s.isEmpty()) return "";

            toLength = fromIndex + toLength;

            if (fromIndex < 0) return "";
            if (toLength < 0) return "";
            if (toLength < fromIndex) return "";

            if (s.length() <= fromIndex) return "";

            return s.substring(fromIndex, toLength);
        } catch (Exception e) {
            return "";
        }
    }

    public static String base64Encode(String string) {

        try {

            byte[] bytes = string.getBytes(UTF);
            return Base64.getEncoder().encodeToString(bytes);

        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] base64Decode(String string) {
        return Base64.getDecoder().decode(string);
    }

    public static String getString(byte[] data) {

        if (data == null) return null;

        return new String(data);
    }
}
