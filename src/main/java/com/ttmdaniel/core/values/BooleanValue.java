package com.ttmdaniel.core.values;

import java.util.Objects;

public class BooleanValue {

    public static final BooleanValue FALSE = new BooleanValue(false) ;
    public static final BooleanValue TRUE = new BooleanValue(true) ;

    private final boolean value ;

    public BooleanValue(boolean value) {
        this.value = value;
    }

    public static BooleanValue of(boolean value) {
        return BooleanValue.of(value) ;
    }

    public boolean getValue() {
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
        BooleanValue that = (BooleanValue) o;
        return Objects.equals(value, that.value);
    }}
