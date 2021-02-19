package com.quadsquad.core;

public interface IReactiveService<I, T> extends IService<I, IObserver<T>> {

    default IObserver<T> newObserver(IExecution<T> taskExecution) {
        return new IReactiveObserver<>(taskExecution) ;
    }
}
