package com.ttmdaniel.core.patterns;

public interface AbstractFactory<T, I> {
    T get(I type) ;
}
