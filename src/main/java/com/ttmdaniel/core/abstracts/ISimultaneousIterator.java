package com.ttmdaniel.core.abstracts;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.BiConsumer;

public class ISimultaneousIterator<T1, T2> {

    private final Collection<T1> collection1;
    private final Collection<T2> collection2;

    public ISimultaneousIterator(Collection<T1> i1, Collection<T2> i2) {
        collection1 = i1 ;
        collection2 = i2 ;
    }

    public void iterate(BiConsumer<T1, T2> consumer) {

        if (collection1 == null || collection2 == null ||
                collection1.isEmpty() || collection2.isEmpty()) return;

        final Iterator<T1> i1 = collection1.iterator();
        final Iterator<T2> i2 = collection2.iterator();

        while (i1.hasNext() && i2.hasNext()) {
            consumer.accept(i1.next(), i2.next());
        }
    }
}
