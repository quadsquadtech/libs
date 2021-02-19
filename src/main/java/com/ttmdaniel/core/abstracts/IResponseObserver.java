package com.ttmdaniel.core.abstracts;

public class IResponseObserver<T> implements IThenableObserver<T> {

     OnNext<T> onNext ;
     OnError onError ;
     OnEnd onEnd ;

    @Override
    public IThenableObserver<T> onError(OnError onError) {

        this.onError = onError;
        return this ;
    }

    @Override
    public IThenableObserver<T> onEnd(OnEnd onEnd) {

        this.onEnd = onEnd;
        return this ;
    }

}
