package com.ttmdaniel.core.values.dates;

import com.ttmdaniel.core.abstracts.IDateFormatter;
import com.ttmdaniel.core.values.IntegerValue;


public class MonthValue extends IntegerValue {

    private static final IDateFormatter.DateValidator validator = new IDateFormatter.DateValidatorUsingDateFormat("MM") ;

    private MonthValue(int value) {
        super(value);
    }

    public static MonthValue of(int value) {
        return new MonthValue(value) ;
    }

    public MonthValue copy() {
        return MonthValue.of(getValue());
    }


    public boolean isValid() {

        return validator.isValid(""+getValue());
    }
}
