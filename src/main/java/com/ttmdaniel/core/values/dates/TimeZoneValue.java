package com.ttmdaniel.core.values.dates;

import com.ttmdaniel.core.abstracts.IEmpty;
import com.ttmdaniel.core.values.StringValue;

public class TimeZoneValue extends StringValue {

    private TimeZoneValue(String value) {
        super(value);
    }

    public static TimeZoneValue of(String value) {
        return new TimeZoneValue(value) ;
    }

    public TimeZoneValue copy() {
        return TimeZoneValue.of(getValue());
    }

    public boolean isValid() {

        if (IEmpty.isEmpty(getValue())) return false ;

        return true ;
    }
}
