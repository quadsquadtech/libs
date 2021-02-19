package com.quadsquad.core;

public interface IMiddleware<T> {

     int getMiddlewareOrderNumber() ;

     void nextMiddleware(T object) ;
     void send(T object) ;
     void error(Exception exception) ;
     void end() ;
}
