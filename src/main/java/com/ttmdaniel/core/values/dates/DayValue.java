package com.ttmdaniel.core.values.dates;

import com.ttmdaniel.core.abstracts.IDateFormatter;
import com.ttmdaniel.core.values.IntegerValue;


public class DayValue extends IntegerValue {

    private static final IDateFormatter.DateValidator validator = new IDateFormatter.DateValidatorUsingDateFormat("dd") ;

    private DayValue(int value) {
        super(value);
    }

    public static DayValue of(int value) {
        return new DayValue(value) ;
    }

    public DayValue copy() {
        return DayValue.of(getValue());
    }

    public boolean isValid() {

        return validator.isValid(""+getValue());
    }
}
