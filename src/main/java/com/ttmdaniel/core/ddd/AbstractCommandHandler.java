package com.ttmdaniel.core.ddd;


public interface AbstractCommandHandler
        <I extends AbstractCommand, T extends AbstractResult<I>> {
    T handle(I command) ;
}
