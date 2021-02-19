package com.quadsquad.core.values.dates;

import com.quadsquad.core.IDateFormatter;
import com.quadsquad.core.values.IntegerValue;


public class YearValue extends IntegerValue {

    private static final IDateFormatter.DateValidator validator = new IDateFormatter.DateValidatorUsingDateFormat("yyyy") ;

    private YearValue(Integer value) {
        super(value);
    }

    public static YearValue of(int value) {
        return new YearValue(value) ;
    }

    public YearValue copy() {
        return YearValue.of(getValue());
    }

    public boolean isValid() {
        return validator.isValid(""+getValue());
    }
}
