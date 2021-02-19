package com.quadsquad.core;

public final class IKeyValuePair<T, I> {

    private T key;
    private I value;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public I getValue() {
        return value;
    }

    public void setValue(I value) {
        this.value = value;
    }
}
