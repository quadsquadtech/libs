package com.quadsquad.core.values.location;

import com.quadsquad.core.values.DoubleValue;

public class AltitudeValue extends DoubleValue {

    public static final double MIN = 0 ;
    public static final double MAX = 1000000000 ;

    private AltitudeValue(double value) {
        super(value);
    }

    public static AltitudeValue of(double value) {

        if (value < MIN) {
            value = MIN ;
        }  else if (value > MAX) {
            value = MAX ;
        }

        return new AltitudeValue(value) ;
    }

    public static AltitudeValue ofMin() {
        return new AltitudeValue(MIN) ;
    }

    public static AltitudeValue ofMax() {
        return new AltitudeValue(MAX) ;
    }

    public AltitudeValue copy() {
        return AltitudeValue.of(getValue());
    }

    public boolean isValid() {
        return true ;
    }
}

