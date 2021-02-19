package com.quadsquad.core;


@FunctionalInterface
public interface IAction<T, I> {
    T action(I val) ;
}