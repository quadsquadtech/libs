package com.ttmdaniel.core.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;

public class DispatchQueue {

    private static final long DELAY = 100;

    private DispatchQueue() {
    }

    public static boolean async(Runnable runnable) {
        return async(runnable, DELAY) ;
    }

    public static boolean async(Runnable runnable, long millis) {

        if (runnable == null) return false;

        CompletableFuture.runAsync(() -> {

            if (millis > 0) sleep(millis);

            runnable.run();
        }, Executors.newFixedThreadPool(1)) ;

        return true ;
    }

    public static void sleep(long millis) {

        try {
            Thread.sleep(millis);
        } catch (Exception ignored) {
        }
    }

    public static ConcurrentQueue concurrentOf(int threadCount) {
        return new ConcurrentQueue(threadCount) ;
    }

    public static class ConcurrentQueue {

        private final List<Runnable> runnableList = new ArrayList<>() ;
        private final int threadCount;

        private boolean isBlockSubmissionCompleted;

        private Runnable completionBlock ;

        private int currentTaskIndex = 0;
        private int completedThreadCount = 0;

        public ConcurrentQueue(int threadCount) {

            if (threadCount < 1) threadCount = 1 ;

            this.threadCount = threadCount;
        }

        public void add(Runnable runnable) {

            if (isBlockSubmissionCompleted) return;

            if (runnable == null) return;
            runnableList.add(runnable) ;
        }

        public void start(Runnable completionBlock) {

            if (isBlockSubmissionCompleted) return;
            isBlockSubmissionCompleted = true ;

            if (completionBlock == null) {
                completionBlock = () -> { };
            }

            this.completionBlock = completionBlock ;

            for (int i = 0; i < threadCount; i++) {
                DispatchQueue.async(this::startInternal) ;
            }
        }

        private void startInternal() {

            while (true) {

                try {

                    if (!runNextTask()) break;
                } catch (Exception ignored) {

                    if (!runNextOfNextTask()) break;
                }
            }
        }

        private boolean runNextOfNextTask() {
            return runNextTask() ;

        }
        private boolean runNextTask() {

            final Runnable runnable = getNextTask();

            if (runnable != null) {

                runNext(runnable);
                return true;
            } else {

                complete() ;
                return false;
            }
        }

        private void runNext(Runnable runnable) {
            runnable.run();
        }

        private synchronized Runnable getNextTask() {

            if (runnableList.size() > currentTaskIndex) {

                currentTaskIndex++;
                return runnableList.get(currentTaskIndex - 1) ;
            }

            return null ;
        }

        private synchronized void complete() {

            completedThreadCount++;
            if (completedThreadCount == threadCount) {
                completionBlock.run();
            }
        }
    }

    public static interface TaskBlock<T> {
        void run(T value) ;
    }

    public static class ThreadLock {

        private enum State {
            INITIATED,
            LOCKED,
            UNLOCKED,
        }


        private final CountDownLatch latch = new CountDownLatch(1);
        private State state = State.INITIATED;


        private ThreadLock() {
        }

        public static ThreadLock newLock() {
            return new ThreadLock();
        }

        public ThreadLock lock() {

            if (this.state != State.INITIATED) return this ;
            try {

                this.state = State.LOCKED;
                latch.await();
                return this ;
            } catch (Exception e) {
                return this ;
            }
        }

        public void unLock() {

            if (this.state != State.LOCKED) return;

            this.state = State.UNLOCKED;
            latch.countDown();
        }
    }
}
