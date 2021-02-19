package com.quadsquad.core.patterns;

public class AbstractDecorator<T> {

    protected AbstractDecorator<T> decorator;

    public AbstractDecorator(AbstractDecorator<T> decorator){
        this.decorator = decorator;
    }

    public void apply() {

        if (decorator == null) return;

        decorator.apply();
    }
}
