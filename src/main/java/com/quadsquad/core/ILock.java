package com.quadsquad.core;

import java.util.concurrent.CountDownLatch;

public class ILock {

    final CountDownLatch lock ;

    private ILock() {
        lock = new CountDownLatch(1) ;
    }

    public static ILock newLock() {
         return new ILock() ;
    }

    public final void lock() {

        try {
            lock.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public final void unLock() {
        lock.countDown();
    }
}
