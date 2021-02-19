package com.quadsquad.core;

import java.time.Instant;
import java.util.Date;

public class IDateUtil {

    private IDateUtil() {
    }

    public static long getTime() {
        return new Date().getTime();
    }

    public static long getMillis(Date date) {
        return date.getTime() ;
    }

    public static Instant getInstant() {
        return Instant.now();
    }

    public static long getNumberOfDaysBetween(Date date1, Date date2) {

        try {

            long difference = date2.getTime() - date1.getTime();
            return (difference / (1000*60*60*24));
        } catch (Exception e) {
            return 0 ;
        }
    }
}
