package com.ttmdaniel.core.values.dates;

import com.ttmdaniel.core.abstracts.IDateFormatter;
import com.ttmdaniel.core.values.IntegerValue;


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
