package com.ttmdaniel.core.abstracts;

class ICallBacHandler<T> implements IObserver<T> {

    private IResponseObserver<T> responseObserver ;

    private boolean isResponseCalled = false ;

    private final Object lock = new Object() ;

    @Override
    public IThenableObserver<T> onNext(OnNext<T> onNext) {

        if (responseObserver != null) return responseObserver ;

        responseObserver = new IResponseObserver<>() ;
        if (onNext == null) return responseObserver;

        responseObserver.onNext = onNext ;

        return responseObserver ;
    }

    @Override
    public void close() {
        end(null);
    }

    public void send(T object) {

        if (responseObserver == null || responseObserver.onNext == null) return;

        final OnNext<T> onNext = responseObserver.onNext;

        if (!isResponseCalled) {
            isResponseCalled = true ;
        }

        synchronized (lock) {
            onNext.onNext(object);
        }
    }

    public void error(Exception exception) {

        if (exception == null) return;
        if (responseObserver == null || responseObserver.onError == null) return;

        final OnError onError = responseObserver.onError;

        responseObserver.onError = null ;
        responseObserver.onEnd = null ;
        responseObserver.onNext = null ;

        synchronized (lock) {
            onError.onError(exception);
        }
    }

    public void end(T object) {

        if (responseObserver == null || responseObserver.onEnd == null) return;
        final OnEnd onEnd = responseObserver.onEnd;

        responseObserver.onEnd = null ;
        responseObserver.onError = null ;

        if (!isResponseCalled && responseObserver.onNext != null) {

            final OnNext<T> onNext = responseObserver.onNext;
            responseObserver.onNext = null ;
            onNext.onNext(object);
        }

        responseObserver.onNext = null ;

        synchronized (lock) {
            onEnd.onEnd();
        }
    }
}
