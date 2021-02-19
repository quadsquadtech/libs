package com.ttmdaniel.core.generators;

import java.security.SecureRandom;

public class RandomStringGenerator {

    public static final String UPPER_CASE_ALPHAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS = "0123456789";
    public static final String LOWER_CASE_ALPHAS = "abcdefghijklmnopqrstuvxyz";


    private static final SecureRandom secureRandom = new SecureRandom() ;

    private RandomStringGenerator() {
    }

    public static String generate(int length) {

        String alphaNumericString = UPPER_CASE_ALPHAS
                + NUMBERS
                + LOWER_CASE_ALPHAS;
        int max = alphaNumericString.length() ;

        final StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {

            int index = secureRandom.nextInt(max - 1) ;
            sb.append(alphaNumericString.charAt(index));
        }

        return sb.toString();
    }
}
