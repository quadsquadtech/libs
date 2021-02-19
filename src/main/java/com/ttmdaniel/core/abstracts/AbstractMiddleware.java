package com.ttmdaniel.core.abstracts;

public class AbstractMiddleware<T> implements IMiddleware<T> {

    protected AbstractMiddleware<T> next;

    private int middlewareOrderNumber = 0;

    public final void setNext(AbstractMiddleware<T> next) {

        this.next = next;
    }

    void setMiddlewareOrderNumber(int middlewareOrderNumber) {
        this.middlewareOrderNumber = middlewareOrderNumber;
    }

    @Override
    public int getMiddlewareOrderNumber() {
        return middlewareOrderNumber;
    }

    @Override
    public void nextMiddleware(T object) {

        if (next == null) return;
        next.nextMiddleware(object);
    }

    @Override
    public void send(T object) {

    }

    @Override
    public void error(Exception exception) {

    }

    @Override
    public void end() {

    }
}
