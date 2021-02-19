package com.ttmdaniel.core.abstracts;

public interface IExecution<T> {

    void run(IReactiveObserver<T> dataObserver) ;
}
