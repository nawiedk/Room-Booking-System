package com.nk.booking.roombookingsystem.domain.model.user;

import java.util.Objects;
import java.util.regex.Pattern;

public class EmailAddress {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,}$");

    private final String value;

    public EmailAddress(String value) {
        if (!EMAIL_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("Invalid email address: " + value);
        }
        this.value = value.toLowerCase();
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmailAddress)) return false;
        EmailAddress that = (EmailAddress) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
