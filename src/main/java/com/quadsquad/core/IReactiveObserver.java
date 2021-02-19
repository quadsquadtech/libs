package com.quadsquad.core;


public final class IReactiveObserver<T> implements IObserver<T> {

    private final IExecution<T> taskExecution ;

    private final ICallBacHandler<T> callBacHandler = new ICallBacHandler<>() ;

    public IReactiveObserver(IExecution<T> taskExecution) {

        this.taskExecution = taskExecution ;
    }

    @Override
    public final IThenableObserver<T> onNext(OnNext<T> onNext) {

        IThenableObserver<T> responseObserver = callBacHandler.onNext(onNext) ;
        if (taskExecution == null) return responseObserver;

        IDispatchQueue.async(this::startAsync) ;

        return responseObserver ;
    }

    @Override
    public void close() {
        end();
    }

    public final void send(T object) {
        callBacHandler.send(object);
    }

    public final void error(Exception exception) {
        callBacHandler.error(exception);
    }

    public final void end() {
        callBacHandler.end(null);
    }

    private void startAsync() {

        IDispatchQueue.sleep(14);

        if (taskExecution == null) {

            send(null) ;
            end() ;
            return ;
        }

        try {

            taskExecution.run(this) ;
        } catch (Exception e) {
            error(e);
        }
    }
}
