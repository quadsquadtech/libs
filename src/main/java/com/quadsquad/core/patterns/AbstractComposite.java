package com.quadsquad.core.patterns;

import java.util.ArrayList;
import java.util.List;

public class AbstractComposite<T extends AbstractComposite<T>> {

    private final List<T> subordinates = new ArrayList<>();

    public final AbstractComposite<T> addSubordinates(T... collection) {

        if (collection == null) return this ;

        for (T c :collection) {

            if (c != null) {
                subordinates.add(c);
            }
        }

        return this ;
    }

    public final AbstractComposite<T> remove(T c) {

        if (c == null) return this;

        subordinates.remove(c);
        return this ;
    }

    public final List<T> getSubordinates() {
        return new ArrayList<>(subordinates);
    }
}
