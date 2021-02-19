package com.ttmdaniel.core.abstracts;

public interface ICoreModuleContext {

    <T> T getBean(Class<T> requiredType) ;
}
