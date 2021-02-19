package com.quadsquad.core.patterns;

public abstract class AbstractObserver<T> {

    protected abstract void willUpdate(T object, String propertyName);
    protected abstract void didUpdate(T object, String propertyName);

}
