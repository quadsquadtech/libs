package com.quadsquad.core.annotations;

import com.quadsquad.core.IMiddleware;
import com.quadsquad.core.IReactiveChain;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ICoreComponent
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface ICoreSequence {

    final class DefaultChain implements IReactiveChain.IChainNode<Object> {

        @Override
        public void processAsync(Object ctx, IMiddleware<Object> middleware) {

        }
    }

    Class<? extends IReactiveChain.IChainNode<?>>[] sequence() default DefaultChain.class;

    // IReactiveChain<Object>

}
