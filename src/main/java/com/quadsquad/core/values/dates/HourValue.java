package com.quadsquad.core.values.dates;

import com.quadsquad.core.IDateFormatter;
import com.quadsquad.core.values.IntegerValue;


public class HourValue extends IntegerValue {

    private static final IDateFormatter.DateValidator validator = new IDateFormatter.DateValidatorUsingDateFormat("HH") ;

    private HourValue(int value) {
        super(value);
    }

    public static HourValue of(int value) {
        return new HourValue(value) ;
    }

    public HourValue copy() {
        return HourValue.of(getValue());
    }

    public boolean isValid() {

        return validator.isValid(""+getValue());
    }
}
