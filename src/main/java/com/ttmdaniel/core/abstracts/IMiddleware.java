package com.ttmdaniel.core.abstracts;

public interface IMiddleware<T> {

     int getMiddlewareOrderNumber() ;

     void nextMiddleware(T object) ;
     void send(T object) ;
     void error(Exception exception) ;
     void end() ;
}
