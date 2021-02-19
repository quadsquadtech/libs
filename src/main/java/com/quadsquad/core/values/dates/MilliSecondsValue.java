package com.quadsquad.core.values.dates;

import com.quadsquad.core.IDateFormatter;
import com.quadsquad.core.values.IntegerValue;


public class MilliSecondsValue extends IntegerValue {

    private static final IDateFormatter.DateValidator validator = new IDateFormatter.DateValidatorUsingDateFormat("ss") ;

    private MilliSecondsValue(int value) {
        super(value);
    }

    public static MilliSecondsValue of(int value) {
        return new MilliSecondsValue(value) ;
    }

    public MilliSecondsValue copy() {
        return MilliSecondsValue.of(getValue());
    }

    public boolean isValid() {

        return validator.isValid(""+getValue());
    }
}
