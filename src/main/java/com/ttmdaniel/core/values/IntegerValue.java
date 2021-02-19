package com.ttmdaniel.core.values;

import java.util.Objects;

public class IntegerValue {

    public static final IntegerValue ZERO = new IntegerValue(0) ;

    private final int value ;

    public IntegerValue(int value) {
        this.value = value;
    }

    public static IntegerValue of(int value) {
        return new IntegerValue(value) ;
    }

    public int getValue() {
        return value ;
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null ) return true;
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;
        IntegerValue that = (IntegerValue) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public String toString() {
        return ""+value;
    }
}
