package com.ttmdaniel.core.values.dates;

import com.ttmdaniel.core.abstracts.IDateFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Locale;

public class DateValue {

    private static final IDateFormatter.DateValidator validator = new IDateFormatter.DateValidatorUsingDateFormat("yyyy/MM/dd/HH/mm/ss") ;
    private static final SimpleDateFormat formatter =new SimpleDateFormat("dd-M-yyyy hh:mm:ss", Locale.ENGLISH);

    private YearValue year;
    private MonthValue month ;
    private DayValue day ;
    private HourValue hour ;
    private MinutesValue minute ;
    private SecondsValue seconds ;
    private MilliSecondsValue milliSeconds ;
    private TimeZoneValue timeZoneValue ;

    private DateValue() {
    }

    public static LocalDateTime convertToLocalDateTimeViaInstant(Date date) {
        return convertToLocalDateTimeViaInstant(date, ZoneId.systemDefault()) ;
    }

    public static LocalDateTime convertToLocalDateTimeViaMilliSeconds(Date date) {
        return convertToLocalDateTimeViaMilliSeconds(date, ZoneId.systemDefault()) ;
    }

    public static LocalDateTime convertToLocalDateTimeViaMilliSeconds(Date date, ZoneId zoneId) {
        return Instant.ofEpochMilli(date.getTime())
                .atZone(zoneId)
                .toLocalDateTime();
    }

    public static LocalDateTime convertToLocalDateTimeViaInstant(Date date, ZoneId zoneId) {
        return date.toInstant()
                .atZone(zoneId)
                .toLocalDateTime();
    }

    public YearValue getYear() {
        return year.copy();
    }

    public MonthValue getMonth() {
        return month;
    }

    public DayValue getDay() {
        return day;
    }

    public HourValue getHour() {
        return hour;
    }

    public MinutesValue getMinute() {
        return minute;
    }

    public SecondsValue getSeconds() {
        return seconds;
    }

    public MilliSecondsValue getMilliSeconds() {
        return milliSeconds;
    }

    public TimeZoneValue getTimeZoneValue() {
        return timeZoneValue;
    }

    public DateValue copy() {

        return toBuilder()
                .build()
                ;
    }

    public Date getDate() throws ParseException {
        return formatter.parse(toString());
    }

    @Override
    public String toString() {

        return "" + day.getValue()
                + "-" + month.getValue()
                + "-" + year.getValue()
                + " " + hour.getValue()
                + ":" + minute.getValue()
                + ":" + seconds.getValue()
                ;
    }

    public DateValue now() {

        return DateValue.newBuilder()
                .now()
                .build() ;
    }

    public Builder toBuilder() {

        return newBuilder()
                .setYear(year)
                .setMonth(month)
                .setDay(day)
                .setHour(hour)
                .setMinute(minute)
                .setSeconds(seconds)
                .setMilliSeconds(milliSeconds)
                .setTimeZoneValue(timeZoneValue)
                ;

    }

    public static Builder newBuilder() {
        return new Builder() ;
    }

    public static final class Builder {

        private YearValue year;
        private MonthValue month ;
        private DayValue day ;
        private HourValue hour ;
        private MinutesValue minute ;
        private SecondsValue seconds ;
        private MilliSecondsValue milliSeconds ;
        private TimeZoneValue timeZoneValue ;

        private Builder() {
        }

        public Builder setYear(int value) {
            year = YearValue.of(value);
            return this ;
        }

        public Builder setMonth(int value) {
            month = MonthValue.of(value) ;
            return this ;
        }

        public Builder setDay(int value) {
            day = DayValue.of(value) ;
            return this ;
        }

        public Builder setHour(int value) {
            hour = HourValue.of(value) ;
            return this ;
        }

        public Builder setMinute(int value) {
            minute = MinutesValue.of(value) ;
            return this ;
        }

        public Builder setSeconds(int value) {
            seconds = SecondsValue.of(value) ;
            return this ;
        }

        public Builder setMilliSeconds(int value) {
            this.milliSeconds = MilliSecondsValue.of(value) ;
            return this ;
        }

        public Builder setTimeZoneValue(String value) {
            this.timeZoneValue = TimeZoneValue.of(value) ;
            return this ;
        }

        public Builder setYear(YearValue value) {

            if (value == null) return this ;

            year = value.copy();
            return this ;
        }

        public Builder setMonth(MonthValue value) {

            if (value == null) return this ;

            month = value.copy();
            return this ;
        }

        public Builder setDay(DayValue value) {

            if (value == null) return this ;

            day = value.copy();
            return this ;
        }

        public Builder setHour(HourValue value) {

            if (value == null) return this ;

            hour = value.copy();
            return this ;
        }

        public Builder setMinute(MinutesValue value) {

            if (value == null) return this ;

            minute = value.copy();
            return this ;
        }

        public Builder setSeconds(SecondsValue value) {

            if (value == null) return this ;

            seconds = value.copy();;
            return this ;
        }

        public Builder setMilliSeconds(MilliSecondsValue value) {

            if (value == null) return this ;

            this.milliSeconds = value.copy();
            return this ;
        }

        public Builder setTimeZoneValue(TimeZoneValue value) {

            if (value == null) return this ;
            this.timeZoneValue = value.copy();
            return this ;
        }

        public Builder setDateValue(DateValue value) {

            if (value == null) return this ;

            year = value.year.copy() ;
            month = value.month.copy() ;
            day = value.day.copy() ;
            hour = value.hour.copy() ;
            minute = value.minute.copy() ;
            seconds = value.seconds.copy() ;
            milliSeconds = value.milliSeconds.copy() ;
            timeZoneValue = value.timeZoneValue.copy() ;

            return this ;
        }

        public Builder setDate(Date value) {

            if (value == null) return this ;
            return getLocalDateTime(convertToLocalDateTimeViaInstant(value)) ;
        }

        public Builder now() {
            return getLocalDateTime(LocalDateTime.now()) ;
        }

        private Builder getLocalDateTime(LocalDateTime localDateTime) {

            return DateValue.newBuilder()
                    .setYear(localDateTime.getYear())
                    .setMonth(localDateTime.getMonthValue())
                    .setDay(localDateTime.getDayOfMonth())
                    .setHour(localDateTime.getHour())
                    .setMinute(localDateTime.getMinute())
                    .setSeconds(localDateTime.getSecond())
                    .setMilliSeconds(localDateTime.get(ChronoField.MILLI_OF_SECOND))
                    ;
        }

        public DateValue build() {

            if (year == null) year = YearValue.of(0) ;
            if (month == null) month = MonthValue.of(0) ;
            if (day == null) day = DayValue.of(0) ;
            if (hour == null) hour = HourValue.of(0) ;
            if (minute == null) minute = MinutesValue.of(0) ;
            if (seconds == null) seconds = SecondsValue.of(0) ;
            if (milliSeconds == null) milliSeconds = MilliSecondsValue.of(0) ;
            if (timeZoneValue == null) timeZoneValue = TimeZoneValue.of("EN") ;

            final DateValue dateValue = new DateValue() ;
            dateValue.year = year ;
            dateValue.month = month ;
            dateValue.day = day ;
            dateValue.hour = hour ;
            dateValue.minute = minute ;
            dateValue.seconds = seconds ;
            dateValue.milliSeconds = milliSeconds ;
            dateValue.timeZoneValue = timeZoneValue ;

            return dateValue ;
        }

    }
}
