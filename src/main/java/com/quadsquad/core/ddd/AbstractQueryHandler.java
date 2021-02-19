package com.quadsquad.core.ddd;


public interface AbstractQueryHandler<I extends AbstractQuery, T extends AbstractResult<I>> {
    T handle(I query) ;
}

