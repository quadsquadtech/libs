package com.ttmdaniel.core.patterns;

public interface AbstractFilter<T> {

     Iterable<T> filter(Iterable<T> collection) ;
}
