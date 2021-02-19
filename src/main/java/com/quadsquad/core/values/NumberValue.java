package com.quadsquad.core.values;

import com.quadsquad.core.IEmpty;

import java.math.BigDecimal;
import java.util.Objects;

public class NumberValue  {

    public static final NumberValue ZERO = new NumberValue(new BigDecimal(0)) ;

    private final BigDecimal value ;

    public NumberValue(BigDecimal value) {
        this.value = value;
    }

    public static NumberValue of(BigDecimal value) {
        return new NumberValue(value) ;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public String toString() {
        return (value != null) ? value.toString() : null;
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
        NumberValue that = (NumberValue) o;
        return Objects.equals(value, that.value);
    }
}
