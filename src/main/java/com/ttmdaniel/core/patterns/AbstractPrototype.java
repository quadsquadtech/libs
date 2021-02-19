package com.ttmdaniel.core.patterns;

public interface AbstractPrototype<T extends AbstractPrototype<T>> {
    T copy() ;
}
