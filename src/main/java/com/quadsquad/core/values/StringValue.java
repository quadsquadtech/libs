package com.quadsquad.core.values;

import com.quadsquad.core.IEmpty;

import java.util.Objects;

public class StringValue {

    public static final StringValue EMPTY = new StringValue("") ;

    private final String value ;

    public StringValue(String value) {
        this.value = value;
    }

    public static StringValue of(String value) {
        return new StringValue(value) ;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object o) {

        if (o == null) return false;
        if (this == o) return true;

        if (getClass() != o.getClass()) return false;
        StringValue that = (StringValue) o;
        return Objects.equals(value, that.value);
    }
}
