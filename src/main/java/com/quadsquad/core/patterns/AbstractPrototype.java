package com.quadsquad.core.patterns;

public interface AbstractPrototype<T extends AbstractPrototype<T>> {
    T copy() ;
}
