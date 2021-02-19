package com.quadsquad.core.patterns;

public interface AbstractFactory<T, I> {
    T get(I type) ;
}
