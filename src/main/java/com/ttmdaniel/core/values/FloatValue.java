package com.ttmdaniel.core.values;

import java.util.Objects;

public class FloatValue {

    public static final FloatValue ZERO = new FloatValue(0) ;

    private final float value ;

    public FloatValue(float value) {
        this.value = value;
    }

    public static FloatValue of(float value) {
        return new FloatValue(value) ;
    }

    public float getValue() {
        return value;
    }

    @Override
    public String toString() {
        return ""+value;
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
        FloatValue that = (FloatValue) o;
        return Objects.equals(value, that.value);
    }}
