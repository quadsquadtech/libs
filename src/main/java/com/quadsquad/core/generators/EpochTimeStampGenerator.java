package com.quadsquad.core.generators;

import java.time.Instant;

public class EpochTimeStampGenerator {

    private EpochTimeStampGenerator() {
    }

    public static long generate() {
        return Instant.now().toEpochMilli();
    }
}
