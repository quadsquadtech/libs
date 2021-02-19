package com.ttmdaniel.core.values;

import java.util.Objects;

public class DoubleValue {

    public static final DoubleValue ZERO = new DoubleValue(0) ;

    private final double value ;

    public DoubleValue(double value) {
        this.value = value;
    }

    public static DoubleValue of(double value) {
        return DoubleValue.of(value) ;
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {

        if (o == null) return false;
        if (this == o) return true;

        if (getClass() != o.getClass()) return false;

        DoubleValue that = (DoubleValue) o;
        return Double.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return ""+value;
    }


}
