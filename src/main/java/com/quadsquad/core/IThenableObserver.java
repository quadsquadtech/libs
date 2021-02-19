package com.quadsquad.core;

public interface IThenableObserver<T> {

//    IThenableObserver<T> onError(OnError onError) ;
    IThenableObserver<T> onError(OnError onError) ;
    IThenableObserver<T> onEnd(OnEnd onEnd) ;
}
