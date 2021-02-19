package com.quadsquad.core.values;


public enum GenderValue  {

    UNKNOWN ,
    MALE,
    FEMALE,
    THIRD_GENDER
    ;

    public GenderValue getValue() {
        return this;
    }

    public boolean isValid() {
        return this != UNKNOWN;
    }

    public String toString() {
        return this.name();
    }

    public boolean equals(GenderValue o) {

        if (o == null) return false;
        return (this == o);
    }
}
