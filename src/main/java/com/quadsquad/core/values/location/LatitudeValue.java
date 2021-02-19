package com.quadsquad.core.values.location;

import com.quadsquad.core.values.DoubleValue;

public class LatitudeValue extends DoubleValue {

    public static final double MIN = -90 ;
    public static final double MAX = 90 ;

    private LatitudeValue(double value) {
        super(value);
    }

    public static LatitudeValue of(double value) {

        if (value < MIN) {
            value = MIN ;
        }  else if (value > MAX) {
            value = MAX ;
        }

        return new LatitudeValue(value) ;
    }

    public static LatitudeValue ofMin() {
        return new LatitudeValue(MIN) ;
    }

    public static LatitudeValue ofMax() {
        return new LatitudeValue(MAX) ;
    }

    public LatitudeValue copy() {
        return LatitudeValue.of(getValue());
    }

    public boolean isValid() {
        return true ;
    }
}
