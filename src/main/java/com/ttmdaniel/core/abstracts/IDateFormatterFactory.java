package com.ttmdaniel.core.abstracts;

import java.text.SimpleDateFormat;
import java.util.HashMap;

public class IDateFormatterFactory {

    private static HashMap<String, SimpleDateFormat> dateFormatHashMap = new HashMap<>();
    public static final String DATE_FORMAT_WITH_TIME = "dd/MM/yyyy hh:mm";
    public static final String DATE_FORMAT_WITH_TIME_SECOND = "dd/MM/yyyy hh:mm:ss";
    public static final String DATE_FORMAT1 = "dd/MM/yyyy";
    public static final String YEAR_MONTH_DD_HH_MM = "yyyy/MM/dd HH:mm";
    public static final String DATE_FORMAT2 = "yyMMdd";
    public static final String TIME_FORMAT_1 = "hhmm";
    public static final String TIME_FORMAT_2 = "hh:mm";

    static {
        dateFormatHashMap.put(DATE_FORMAT2, new SimpleDateFormat(DATE_FORMAT2));
        dateFormatHashMap.put(DATE_FORMAT_WITH_TIME, new SimpleDateFormat(DATE_FORMAT_WITH_TIME_SECOND));
        dateFormatHashMap.put(DATE_FORMAT1, new SimpleDateFormat(DATE_FORMAT1));
        dateFormatHashMap.put(TIME_FORMAT_1, new SimpleDateFormat(TIME_FORMAT_1));
        dateFormatHashMap.put(TIME_FORMAT_2, new SimpleDateFormat(TIME_FORMAT_2));
        dateFormatHashMap.put(YEAR_MONTH_DD_HH_MM, new SimpleDateFormat(YEAR_MONTH_DD_HH_MM));
    }

    private IDateFormatterFactory() {
    }

    public static SimpleDateFormat get(String format) {

        if (format == null || !dateFormatHashMap.containsKey(format)) format = DATE_FORMAT_WITH_TIME;

        return dateFormatHashMap.get(format);
    }
}
