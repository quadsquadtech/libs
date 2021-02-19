package com.quadsquad.core;

import java.util.concurrent.CompletableFuture;

public class IDispatchQueue {

    private IDispatchQueue() {
    }

    public static boolean async(Runnable runnable) {

        if (runnable == null) return false;

        try {

            CompletableFuture.runAsync(runnable) ;
        } catch (Exception e) {
            throw e ;
        }

        return true ;
    }

    public static void sleep(long millis) {

        try {
            Thread.sleep(millis);
        } catch (Exception ignored) {
        }
    }

}
