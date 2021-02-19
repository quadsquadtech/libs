package com.ttmdaniel.core.patterns;

import java.util.ArrayList;
import java.util.List;

public class Memento<T extends AbstractPrototype<T>> {

    private final List<T> states = new ArrayList<>();

    private Memento(T obj) {
        states.add(obj) ;
    }

    public static <T extends AbstractPrototype<T>> Memento<T> of(T obj) {
        return new Memento<>(obj) ;
    }

    public final Memento<T> saveState() {

        if (states.isEmpty()) return this ;

        final T last = states.get(states.size() - 1) ;
        if (last == null) return this ;

        return saveState(last) ;
    }

    public final Memento<T> saveState(T obj) {

        if (obj == null) {
            states.add(null);
            return this ;
        }

        final T copy = obj.copy() ;

        states.add(copy);

        return this ;
    }

    public final T getOriginalState() {

        if (states.isEmpty()) return null ;

        final T obj = states.get(0) ;

        if (obj == null) {
            return null ;
        }

        return obj.copy() ;
    }

    public final T getState() {

        if (states.isEmpty()) return null ;
        return states.get(states.size() - 1) ;
    }


    public Memento<T> rollBackToPreviousState() {

        if (states.size() == 1) return this ;

        states.remove(states.size() - 1) ;

        return this ;
    }

    public Memento<T> rollBackToOriginalState() {

        if (states.size() == 1) return this ;

        final T first = states.get(0) ;
        states.clear();
        states.add(first);

        return this ;
    }

    public Memento<T> clear() {

        states.clear();

        return this ;
    }


}
