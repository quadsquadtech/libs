package com.ttmdaniel.core.abstracts;

public class ILogger {

    public ILogger() { }

    public void trace(String msg) {
        System.out.println("trace : " + msg);
    }

    public void trace(String format, Object... arguments) {
        System.out.println("trace : " + format + arguments);
    }

    public void trace(String msg, Throwable t) {
        System.out.println("trace : " + msg + t.getMessage());
    }

    public void debug(String msg) {
        System.out.println("debug : " + msg);
    }

    public void debug(String format, Object... arguments) {
        System.out.println("debug : " + format + arguments);
    }

    public void debug(String msg, Throwable t) {
        System.out.println("debug : " + msg + t.getMessage());
    }

    public void info(String msg) {
        System.out.println("info : " + msg);
    }

    public void info(String format, Object... arguments) {
        System.out.println("info : " + format + arguments);
    }

    public void info(String msg, Throwable t) {
        System.out.println("info : " + msg + t.getMessage());
    }

    public void warn(String msg) {
        System.out.println("warn : " + msg);
    }

    public void warn(String format, Object... arguments) {
        System.out.println("warn : " + format + arguments);
    }

    public void warn(String msg, Throwable t) {
        System.out.println("warn : " + msg + t.getMessage());
    }

    public void error(String msg) {
        System.out.println("error : " + msg);
    }

    public void error(String format, Object... arguments) {
        System.out.println("error : " + format + arguments);
    }

    public void error(String msg, Throwable t) {
        System.out.println("error : " + msg + t.getMessage());
    }


    public void trace(Class<?> clazz, String msg) {
        System.out.println("trace : " + clazz + " " + msg);
    }

    public void trace(Class<?> clazz, String format, Object... arguments) {
        System.out.println("trace : " + clazz + " " + format + arguments);
    }

    public void trace(Class<?> clazz, String msg, Throwable t) {
        System.out.println("trace : " + clazz + " " + msg + t.getMessage());
    }

    public void debug(Class<?> clazz, String msg) {
        System.out.println("debug : " + clazz + " " + msg);
    }

    public void debug(Class<?> clazz, String format, Object... arguments) {
        System.out.println("debug : " + clazz + " " + format + arguments);
    }

    public void debug(Class<?> clazz, String msg, Throwable t) {
        System.out.println("debug : " + clazz + " " + msg + t.getMessage());
    }

    public void info(Class<?> clazz, String msg) {
        System.out.println("info : " + clazz + " " + msg);
    }

    public void info(Class<?> clazz, String format, Object... arguments) {
        System.out.println("info : " + clazz + " " + format + arguments);
    }

    public void info(Class<?> clazz, String msg, Throwable t) {
        System.out.println("info : "  + clazz + " "+ msg + t.getMessage());
    }

    public void warn(Class<?> clazz, String msg) {
        System.out.println("warn : " + clazz + " " + msg);
    }

    public void warn(Class<?> clazz, String format, Object... arguments) {
        System.out.println("warn : " + clazz + " " + format + arguments);
    }

    public void warn(Class<?> clazz, String msg, Throwable t) {
        System.out.println("warn : " + clazz + " " + msg + t.getMessage());
    }

    public void error(Class<?> clazz, String msg) {
        System.out.println("error : " + clazz + " " + msg);
    }

    public void error(Class<?> clazz, String format, Object... arguments) {
        System.out.println("error : " + clazz + " " + format + arguments);
    }

    public void error(Class<?> clazz, String msg, Throwable t) {
        System.out.println("error : " + clazz + " " + msg + t.getMessage());
    }
}
