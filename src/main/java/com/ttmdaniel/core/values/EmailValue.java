package com.ttmdaniel.core.values;

import java.util.regex.Pattern;

public class EmailValue extends StringValue {

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\."+
            "[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
            "A-Z]{2,7}$";

    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    private EmailValue(String value) {
        super(value);
    }

    public static EmailValue of(String value) {
        return new EmailValue(value) ;
    }

    public EmailValue copy() {
        return EmailValue.of(getValue());
    }

    public boolean isValid() {

        return EMAIL_PATTERN.matcher(getValue()).matches();
    }
}
