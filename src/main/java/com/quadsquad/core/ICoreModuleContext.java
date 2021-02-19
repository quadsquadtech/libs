package com.quadsquad.core;

public interface ICoreModuleContext {

    <T> T getBean(Class<T> requiredType) ;
}
