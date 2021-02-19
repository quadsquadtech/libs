package com.ttmdaniel.core.patterns;

public interface AbstractTask<I, T> {

    T execute(I input) ;
}
