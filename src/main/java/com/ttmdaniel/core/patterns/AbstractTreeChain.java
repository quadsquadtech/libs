package com.ttmdaniel.core.patterns;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTreeChain<T> {

    private final List<AbstractTreeChain<T>> chains = new ArrayList<>() ;

    public final AbstractTreeChain<T> setNext(Iterable<AbstractTreeChain<T>> nextChainSequence) {

        if (nextChainSequence == null) return this ;

        for (AbstractTreeChain<T> nextChain : nextChainSequence) {
            setNext(nextChain) ;
        }

        return this;
    }

    public final AbstractTreeChain<T> setNext(AbstractTreeChain<T>... nextChainSequence) {

        if (nextChainSequence == null) return this ;

        for (AbstractTreeChain<T> nextChain : nextChainSequence) {
            setNext(nextChain) ;
        }

        return this;
    }

    public final AbstractTreeChain<T> setNext(AbstractTreeChain<T> nextChain) {

        if (nextChain == null) return this ;

        chains.add(nextChain) ;

        return this;
    }

    public void process(T request) {

        for (AbstractTreeChain<T> nextChain : chains) {
            nextChain.process(request);
        }
    }
}
