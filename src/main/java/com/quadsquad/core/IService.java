package com.quadsquad.core;

public interface IService<I, T> {

    T submit(I request);
}
