package com.ttmdaniel.core.requestprocessing;

import com.ttmdaniel.core.abstracts.IExecution;
import com.ttmdaniel.core.abstracts.IMiddleware;
import com.ttmdaniel.core.abstracts.IObserver;
import com.ttmdaniel.core.abstracts.IReactiveChain;
import com.ttmdaniel.core.abstracts.IReactiveObserver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class IGenericExecutionProcessor<Command, Context, Result> extends IReactiveChain<Context> {

    private final EndProcessLogic<Context> sendChain = new EndProcessLogic<>() ;

   // @SafeVarargs
    public final IGenericExecutionProcessor<Command, Context, Result> addScenes(
            IReactiveChain.IChainNode<?>... chainNodes) throws IGenericExecutionException {

        final List<IReactiveChain.IChainNode<Context>> list = new ArrayList<>() ;

        try {

            for (IReactiveChain.IChainNode<?> node : chainNodes) {

                if (node != null) {

                    IReactiveChain.IChainNode<Context> node1 = (IReactiveChain.IChainNode<Context>)node ;
                    list.add(node1) ;
                }
            }

            super.addList(list);
        } catch (Exception e) {
            throw new IGenericExecutionException(e.getMessage()) ;
        }

        return this ;
    }

    public final IGenericExecutionProcessor<Command, Context, Result> addScenes(Collection<IReactiveChain.IChainNode<?>> chainNodes) throws IGenericExecutionException {

        final List<IReactiveChain.IChainNode<Context>> list = new ArrayList<>() ;

        try {

            for (IReactiveChain.IChainNode<?> node : chainNodes) {

                if (node != null) {

                    IReactiveChain.IChainNode<Context> node1 = (IReactiveChain.IChainNode<Context>)node ;
                    list.add(node1) ;
                }
            }

            super.addList(list);
        } catch (Exception e) {
            throw new IGenericExecutionException(e.getMessage()) ;
        }

        return this ;
    }

//    public abstract IObserver<Result> processCommand(Command command) ;

    protected <T> IObserver<T> newObserver(IExecution<T> taskExecution) {
        return new IReactiveObserver<>(taskExecution) ;
    }

    public IChainNode<Context> when() {
        return null ;
    }

    public IChainNode<Context> requestComes() {
        return null ;
    }

    public IChainNode<Context> thenReceiveTheRequest() {
        return null ;
    }

    public IChainNode<Context> receiveTheRequest() {
        return null ;
    }

    public IChainNode<Context> receive() {
        return null ;
    }

    public IChainNode<Context> first() {
        return null ;
    }

    public IChainNode<Context> then() {
        return null ;
    }

    public IChainNode<Context> afterThat() {
        return null ;
    }

    public IChainNode<Context> after() {
        return null ;
    }

    public IChainNode<Context> onceCompleted() {
        return null ;
    }

    public IChainNode<Context> wonderful() {
        return null ;
    }

    public IChainNode<Context> yeahCompleted() {
        return null ;
    }

    public IChainNode<Context> yeahWeMadeIt() {
        return null ;
    }

    public IChainNode<Context> ifValid() {
        return null ;
    }

    public IChainNode<Context> ifNotValid() {
        return null ;
    }

    public IChainNode<Context> hasAnyError() {
        return null ;
    }

    public IChainNode<Context> ifAnyErrorOccurred() {
        return null ;
    }

    public IChainNode<Context> isValid() {
        return null ;
    }

    public IChainNode<Context> ifExists() {
        return null ;
    }

    public IChainNode<Context> ifNotExists() {
        return null ;
    }

    public IChainNode<Context> isInValid() {
        return null ;
    }

    public IChainNode<Context> ifSucks() {
        return null ;
    }

    public IChainNode<Context> ifCompleted() {
        return null ;
    }

    public IChainNode<Context> ifFound() {
        return null ;
    }

    public IChainNode<Context> checkIfFound() {
        return null ;
    }

    public IChainNode<Context> ifNotFound() {
        return null ;
    }

    public IChainNode<Context> checkIfNotFound() {
        return null ;
    }

    public IChainNode<Context> checkIfMatchingFound() {
        return null ;
    }

    public IChainNode<Context> and() {
        return null ;
    }

    public IChainNode<Context> checkIfMatchingNotFound() {
        return null ;
    }

    public IChainNode<Context> ifMatchingFound() {
        return null ;
    }

    public IChainNode<Context> ifMatchingNotFound() {
        return null ;
    }

    public IChainNode<Context> ifErrorsFound() {
        return null ;
    }

    public IChainNode<Context> ifErrorsNotFound() {
        return null ;
    }

    public IChainNode<Context> ifAnyErrors() {
        return null ;
    }

    public IChainNode<Context> ifNoErrors() {
        return null ;
    }

    public IChainNode<Context> throwException() {
        return null ;
    }

    public IChainNode<Context> ifNotFoundAnyErrors() {
        return null ;
    }

    public IChainNode<Context> send() {
        return sendChain ;
    }

    public IChainNode<Context> startScene() {
        return sendChain ;
    }

    public IChainNode<Context> endScene() {
        return sendChain ;
    }

    public IChainNode<Context> newScene() {
        return null ;
    }

    public IChainNode<Context> sceneNumber(int sceneNumber) {
        return null ;
    }

    public IChainNode<Context> scene(int sceneNumber) {
        return null ;
    }

    public IChainNode<Context> step(int stepNumber) {
        return null ;
    }

    private static class EndProcessLogic<T> implements IReactiveChain.IChainNode<T> {

        @Override
        public void processAsync(T ctx, IMiddleware<T> middleware) {

            middleware.send(ctx);
            middleware.end();
        }
    }
}
