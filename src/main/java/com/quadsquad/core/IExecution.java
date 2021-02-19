package com.quadsquad.core;

public interface IExecution<T> {

    void run(IReactiveObserver<T> dataObserver) ;
}
