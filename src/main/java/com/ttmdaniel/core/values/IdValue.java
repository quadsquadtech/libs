package com.ttmdaniel.core.values;

public class IdValue extends StringValue {

    private IdValue(String value) {
        super(value);
    }

    public static IdValue of(String value) {
        return new IdValue(value) ;
    }

}
