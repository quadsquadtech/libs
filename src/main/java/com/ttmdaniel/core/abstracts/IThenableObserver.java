package com.ttmdaniel.core.abstracts;

public interface IThenableObserver<T> {

//    IThenableObserver<T> onError(OnError onError) ;
    IThenableObserver<T> onError(OnError onError) ;
    IThenableObserver<T> onEnd(OnEnd onEnd) ;
}
