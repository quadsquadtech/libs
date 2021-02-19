package com.quadsquad.core;

import java.util.ArrayList;
import java.util.List;

public class IChain<T> {

    private final List<IChainNode<T>> chainNodes = new ArrayList<>();


    @SafeVarargs
    private final IChain<T> add(IChainNode<T>... chainNodes) {

        if (chainNodes == null) return this;

        for (IChainNode<T> chainNode :chainNodes) {

            if (chainNode != null) {
                this.chainNodes.add(chainNode) ;
            }
        }

        return this;
    }

    public interface IChainNode<T> {
        void process(T object);
    }

    public void process(T object) {

        for (IChainNode<T> chainNode : chainNodes) {
            chainNode.process(object);
        }
    }
}
