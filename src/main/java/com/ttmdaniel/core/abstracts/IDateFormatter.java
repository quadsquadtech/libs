package com.ttmdaniel.core.abstracts;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public final class IDateFormatter {

    public static final DateTimeFormatter dateFormatter = DateTimeFormatter.BASIC_ISO_DATE;
    public static final DateValidator validator = new DateValidatorUsingLocalDate(dateFormatter);



    public interface DateValidator {
        boolean isValid(String dateStr);
    }



    public static class DateValidatorUsingDateFormat implements DateValidator {

        private final String dateFormat;

        public DateValidatorUsingDateFormat(String dateFormat) {
            this.dateFormat = dateFormat;
        }

        @Override
        public boolean isValid(String dateStr) {

            DateFormat sdf = new SimpleDateFormat(this.dateFormat);
            sdf.setLenient(false);
            try {
                sdf.parse(dateStr);
            } catch (ParseException e) {
                return false;
            }
            return true;
        }
    }

    public static class DateValidatorUsingLocalDate implements DateValidator {

        private DateTimeFormatter dateFormatter;

        public DateValidatorUsingLocalDate(DateTimeFormatter dateFormatter) {
            this.dateFormatter = dateFormatter;
        }

        @Override
        public boolean isValid(String dateStr) {
            try {
                LocalDate.parse(dateStr, this.dateFormatter);
            } catch (DateTimeParseException e) {
                return false;
            }
            return true;
        }
    }


    private static class DateValidatorUsingDateTimeFormatter implements DateValidator {

        private DateTimeFormatter dateFormatter;

        public DateValidatorUsingDateTimeFormatter(DateTimeFormatter dateFormatter) {
            this.dateFormatter = dateFormatter;
        }

        @Override
        public boolean isValid(String dateStr) {
            try {
                this.dateFormatter.parse(dateStr);
            } catch (DateTimeParseException e) {
                return false;
            }
            return true;
        }
    }
}
