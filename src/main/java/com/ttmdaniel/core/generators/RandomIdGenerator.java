package com.ttmdaniel.core.generators;

import java.util.UUID;

public final class RandomIdGenerator {

    private RandomIdGenerator() {}

    public static String generate() {
        return UUID.randomUUID().toString() ;
    }

}
