package com.ttmdaniel.core.abstracts;

import java.util.ArrayList;
import java.util.List;

public interface IAdaptor<I, T> {

    T adoptFrom(I object);
    default I adoptTo(T object) {return null; }

    default List<T> adoptFrom(List<I> objects) {

        final List<T> list = new ArrayList<>();

        if (objects == null) return list;

        for (I object : objects) {

            final T t = adoptFrom(object) ;
            if (t != null) {
                list.add(t) ;
            }
        }

        return list ;
    }

    default List<I> adoptTo(List<T> objects) {

        final List<I> list = new ArrayList<>();

        if (objects == null) return list;

        for (T object : objects) {

            final I t = adoptTo(object) ;
            if (t != null) {
                list.add(t) ;
            }
        }

        return list ;
    }
}
