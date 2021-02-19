package com.quadsquad.core.patterns;

public interface AbstractAdaptor<I, O> {
    O adopt(I input) ;
}
