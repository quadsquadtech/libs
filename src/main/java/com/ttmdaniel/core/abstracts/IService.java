package com.ttmdaniel.core.abstracts;

public interface IService<I, T> {

    T submit(I request);
}
