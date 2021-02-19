package com.quadsquad.core;

import java.util.ArrayList;
import java.util.List;

public class IReactiveChain<T> {

    private final List<IChainNode<T>> chainNodes = new ArrayList<>();

    public interface IChainNode<T> {

        void processAsync(T ctx, IMiddleware<T> middleware);
    }

    @SafeVarargs
    protected final IReactiveChain<T> add(IChainNode<T>... chainNodes) {

        if (chainNodes == null) return this;

        for (IChainNode<T> chainNode :chainNodes) {

            if (chainNode != null) {
                this.chainNodes.add(chainNode) ;
            }
        }

        return this;
    }

    protected final IReactiveChain<T> addList(List<IChainNode<T>> chainNodes) {

        if (chainNodes == null) return this;

        for (IChainNode<T> chainNode :chainNodes) {

            if (chainNode != null) {
                this.chainNodes.add(chainNode) ;
            }
        }

        return this;
    }


    public final IObserver<T> processAsync(T object) {

        AbstractMiddleware<T> middlewareCurrentPointer = new AbstractMiddleware<>() ;
        final ChainKnob<T> chainKnob = new ChainKnob<>(middlewareCurrentPointer, object);

        if (object == null) return chainKnob;

        int middlewareOrderNumber = -1;
        for (IChainNode<T> chainNode : chainNodes) {

            final ChainNode<T> newMiddleware = new ChainNode<>(chainKnob, chainNode) ;
            newMiddleware.setMiddlewareOrderNumber(middlewareOrderNumber);
            middlewareCurrentPointer.setNext(newMiddleware) ;
            middlewareCurrentPointer = newMiddleware ;

            middlewareOrderNumber++ ;
        }

        middlewareCurrentPointer.setNext(new ChainNode<>(chainKnob, null)) ;

        return chainKnob ;
    }


    static class ChainKnob<T> implements IObserver<T> {

        private final AbstractMiddleware<T> firstNode;
        private final T object ;
        private ICallBacHandler<T> callBacHandler = new ICallBacHandler<>() ;


        ChainKnob(AbstractMiddleware<T> firstNode, T object) {

            this.firstNode = firstNode ;
            this.object = object ;
        }

        @Override
        public IThenableObserver<T> onNext(OnNext<T> onNext) {

            callBacHandler.onNext(onNext);

            IThenableObserver<T> responseObserver = callBacHandler.onNext(onNext) ;
            if (firstNode == null) return responseObserver;

            IDispatchQueue.async(this::startAsync) ;

            return responseObserver ;
        }

        @Override
        public void close() {
            end(object);
        }

        public void send(T object) {
            callBacHandler.send(object);
        }

        public void error(Exception exception) {
            callBacHandler.error(exception);
        }

        public void end(T object) {
            callBacHandler.end(object);
        }

        void startAsync() {

            IDispatchQueue.sleep(100);

            if (firstNode == null) {

                send(null) ;
                end(object) ;
                return ;
            }

            try {

                firstNode.nextMiddleware(object);
            } catch (Exception e) {
                error(e);
            }
        }
    }

    static class ChainNode<T> extends AbstractMiddleware<T> {

        ChainKnob<T> callBackNode;
        IChainNode<T> nextChainNode;

        private T object ;

        ChainNode(ChainKnob<T> chainKnob, IChainNode<T> chainNode) {

            this.callBackNode = chainKnob ;
            this.nextChainNode = chainNode ;
        }

        @Override
        public void nextMiddleware(T object) {

            this.object = object;
            if (next != null) {
                processAsync(next, object);
            } else {
                end() ;
            }
        }

        @Override
        public void send(T object) {

            if (callBackNode != null) {
                callBackNode.send(object);
            }
        }

        @Override
        public void error(Exception exception) {

            nextChainNode = null ;

            if (callBackNode != null) {

                final ChainKnob<T> callBackNode = this.callBackNode ;
                this.callBackNode = null ;

                callBackNode.error(exception);
            }
        }

        @Override
        public void end() {

            nextChainNode = null ;

            if (callBackNode != null) {

                final ChainKnob<T> callBackNode = this.callBackNode ;
                this.callBackNode = null ;

                callBackNode.end(object);
            }
        }

        private void processAsync(AbstractMiddleware<T> next, T object) {

            if (nextChainNode == null) {
                end() ;
                return ;
            }
            try {
                IDispatchQueue.async(() -> {
                    try {
                        nextChainNode.processAsync(object, next);
                    } catch (Exception e) {
                        error(e);
                    }
                } ) ;
            } catch (Exception e) {
                error(e);
            }
        }
    }
}
