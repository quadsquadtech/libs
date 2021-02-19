package com.ttmdaniel.core.abstracts;


@FunctionalInterface
public interface IAction<T, I> {
    T action(I val) ;
}