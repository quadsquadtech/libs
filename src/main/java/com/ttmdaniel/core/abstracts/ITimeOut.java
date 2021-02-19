package com.ttmdaniel.core.abstracts;


public class ITimeOut {

    private ITimeOut() {
    }

    public static void setTimeOut(Runnable task, long milliseconds) {

        if (task == null) return;
        if (milliseconds <= 0) {
            milliseconds = 100 ;
        }

        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        task.run();
                    }
                },
                milliseconds
        );
    }
}
