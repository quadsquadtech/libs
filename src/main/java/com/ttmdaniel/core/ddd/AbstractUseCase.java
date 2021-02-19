package com.ttmdaniel.core.ddd;


public interface AbstractUseCase<I extends AbstractRequest, T extends AbstractResult<I>> {
    T execute(I request) ;
}
