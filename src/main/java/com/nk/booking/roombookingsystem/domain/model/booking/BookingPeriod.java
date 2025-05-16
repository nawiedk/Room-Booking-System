package com.nk.booking.roombookingsystem.domain.model.booking;

import java.time.LocalDateTime;
import java.util.Objects;

public class BookingPeriod {
    private final LocalDateTime start;
    private final LocalDateTime end;

    public BookingPeriod(LocalDateTime start, LocalDateTime end) {
        if (start == null || end == null) {
            throw new IllegalArgumentException("Start and end time must not be null.");
        }
        if (!start.isBefore(end)) {
            throw new IllegalArgumentException("Start time must be before end time.");
        }
        this.start = start;
        this.end = end;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public boolean overlapsWith(BookingPeriod other) {
        return start.isBefore(other.end) && end.isAfter(other.start);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookingPeriod)) return false;
        BookingPeriod that = (BookingPeriod) o;
        return start.equals(that.start) && end.equals(that.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}
