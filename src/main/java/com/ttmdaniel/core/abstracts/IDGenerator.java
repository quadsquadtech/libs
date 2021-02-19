package com.ttmdaniel.core.abstracts;

import java.util.UUID;

public class IDGenerator {

    private IDGenerator() {

    }

    public static UUID randomUUID() {
        return UUID.randomUUID() ;
    }
}
