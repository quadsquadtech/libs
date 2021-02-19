package com.ttmdaniel.core.values;

public class UrlQueryParamsValue extends StringValue {

    private UrlQueryParamsValue(String value) {
        super(value);
    }

    public static UrlQueryParamsValue of(String value) {
        return new UrlQueryParamsValue(value) ;
    }
}
