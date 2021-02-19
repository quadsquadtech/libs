package com.ttmdaniel.core.patterns;

import java.util.ArrayList;
import java.util.List;

public  interface AbstractConverter<I, T> {

    T convert(I object);

    default List<T> convert(List<I> objects) {

        final List<T> list = new ArrayList<>();

        if (objects == null) return list;

        for (I object : objects) {

            final T t = convert(object) ;
            if (t != null) {
                list.add(t) ;
            }
        }

        return list ;
    }
}
