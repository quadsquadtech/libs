package com.ttmdaniel.core.values.location;


import com.ttmdaniel.core.values.DoubleValue;

public class LongitudeValue extends DoubleValue {

    public static final double MIN = -180 ;
    public static final double MAX = 180 ;

    private LongitudeValue(double value) {
        super(value);
    }

    public static LongitudeValue of(double value) {

        if (value < MIN) {
            value = MIN ;
        }  else if (value > MAX) {
            value = MAX ;
        }

        return new LongitudeValue(value) ;
    }

    public static LongitudeValue ofMin() {
        return new LongitudeValue(MIN) ;
    }

    public static LongitudeValue ofMax() {
        return new LongitudeValue(MAX) ;
    }

    public LongitudeValue copy() {
        return LongitudeValue.of(getValue());
    }

    public boolean isValid() {
        return true ;
    }
}
