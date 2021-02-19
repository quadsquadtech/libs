package com.ttmdaniel.core.values.dates;

import com.ttmdaniel.core.abstracts.IDateFormatter;
import com.ttmdaniel.core.values.IntegerValue;


public class MinutesValue extends IntegerValue {

    private static final IDateFormatter.DateValidator validator = new IDateFormatter.DateValidatorUsingDateFormat("mm") ;

    private MinutesValue(int value) {
        super(value);
    }

    public static MinutesValue of(int value) {
        return new MinutesValue(value) ;
    }

    public MinutesValue copy() {
        return MinutesValue.of(getValue());
    }

    public boolean isValid() {

        return validator.isValid(""+getValue());
    }
}
