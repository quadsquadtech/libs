package com.ttmdaniel.core.abstracts;

import java.time.Instant;

public class IEpochTimeStampGenerator {

    private IEpochTimeStampGenerator() {
    }

    public static long generate() {
        return Instant.now().toEpochMilli();
    }
}
