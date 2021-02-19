package com.ttmdaniel.core.values.dates;

import com.ttmdaniel.core.abstracts.IDateFormatter;
import com.ttmdaniel.core.values.IntegerValue;


public class SecondsValue extends IntegerValue {

    private static final IDateFormatter.DateValidator validator = new IDateFormatter.DateValidatorUsingDateFormat("ss") ;

    private SecondsValue(int value) {
        super(value);
    }

    public static SecondsValue of(int value) {
        return new SecondsValue(value) ;
    }

    public SecondsValue copy() {
        return SecondsValue.of(getValue());
    }

    public boolean isValid() {

        return validator.isValid(""+getValue());
    }
}
