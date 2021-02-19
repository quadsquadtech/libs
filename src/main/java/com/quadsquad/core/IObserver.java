package com.quadsquad.core;

public interface IObserver<T> {

    IThenableObserver<T> onNext(OnNext<T> onNext) ;
    void close();

    static <T> IObserver<T> newObserver(IExecution<T> taskExecution) {
        return new IReactiveObserver<>(taskExecution) ;
    }
}
