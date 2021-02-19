package com.quadsquad.core.utils;

import java.io.File;
import java.nio.file.Files;

public class FileLoader {

    private FileLoader() {}
    public static String loadStringFromPath(String path) {

        try {

            final File file = new File(path);
            return new String(Files.readAllBytes(file.toPath()));

        } catch (Exception e) {
            return null;
        }
    }
}
