package com.ttmdaniel.core.abstracts;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


public class IDateComponent {

    public final int year;
    public final int month;
    public final int day;

    private IDateComponent(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static IDateComponent get(Date date) {

        final LocalDate localDate = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        return new IDateComponent(localDate.getYear(),
                localDate.getMonthValue(),
                localDate.getDayOfMonth()
        );
    }
}
