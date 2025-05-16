package com.nk.booking.roombookingsystem.domain.model.booking;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {

    private BookingPeriod createPeriod() {
        return new BookingPeriod(
                LocalDateTime.of(2024, 5, 1, 10, 0),
                LocalDateTime.of(2024, 5, 1, 11, 0)
        );
    }

    @Test
    void bookingShouldBeCreatedWithDefaultStatusBooked() {
        Booking booking = new Booking(
                UUID.randomUUID(),
                UUID.randomUUID(),
                UUID.randomUUID(),
                createPeriod()
        );

        assertEquals(BookingStatus.BOOKED, booking.getStatus());
    }

    @Test
    void bookingCanBeCanceled() {
        Booking booking = new Booking(
                UUID.randomUUID(),
                UUID.randomUUID(),
                UUID.randomUUID(),
                createPeriod()
        );

        booking.cancel();
        assertEquals(BookingStatus.CANCELED, booking.getStatus());
    }

    @Test
    void cancelingAlreadyCanceledBookingShouldFail() {
        Booking booking = new Booking(
                UUID.randomUUID(),
                UUID.randomUUID(),
                UUID.randomUUID(),
                createPeriod()
        );

        booking.cancel();
        assertThrows(IllegalStateException.class, booking::cancel);
    }

    @Test
    void bookingCanBeCompleted() {
        Booking booking = new Booking(
                UUID.randomUUID(),
                UUID.randomUUID(),
                UUID.randomUUID(),
                createPeriod()
        );

        booking.complete();
        assertEquals(BookingStatus.COMPLETED, booking.getStatus());
    }

    @Test
    void completedOrCanceledBookingCannotBeCompletedAgain() {
        Booking booking = new Booking(
                UUID.randomUUID(),
                UUID.randomUUID(),
                UUID.randomUUID(),
                createPeriod()
        );

        booking.cancel();
        assertThrows(IllegalStateException.class, booking::complete);

        Booking another = new Booking(
                UUID.randomUUID(),
                UUID.randomUUID(),
                UUID.randomUUID(),
                createPeriod()
        );

        another.complete();
        assertThrows(IllegalStateException.class, another::complete);
    }

    @Test
    void overlappingPeriodsShouldBeDetected() {
        BookingPeriod a = new BookingPeriod(
                LocalDateTime.of(2024, 5, 1, 9, 0),
                LocalDateTime.of(2024, 5, 1, 11, 0)
        );

        BookingPeriod b = new BookingPeriod(
                LocalDateTime.of(2024, 5, 1, 10, 30),
                LocalDateTime.of(2024, 5, 1, 11, 30)
        );

        assertTrue(a.overlapsWith(b));
        assertTrue(b.overlapsWith(a));
    }

    @Test
    void nonOverlappingPeriodsShouldNotBeDetectedAsOverlapping() {
        BookingPeriod a = new BookingPeriod(
                LocalDateTime.of(2024, 5, 1, 8, 0),
                LocalDateTime.of(2024, 5, 1, 9, 0)
        );

        BookingPeriod b = new BookingPeriod(
                LocalDateTime.of(2024, 5, 1, 9, 0),
                LocalDateTime.of(2024, 5, 1, 10, 0)
        );

        assertFalse(a.overlapsWith(b));
        assertFalse(b.overlapsWith(a));
    }

    @Test
    void creatingInvalidBookingPeriodShouldThrow() {
        LocalDateTime now = LocalDateTime.now();

        assertThrows(IllegalArgumentException.class, () ->
                new BookingPeriod(now.plusHours(1), now));

        assertThrows(IllegalArgumentException.class, () ->
                new BookingPeriod(null, now));

        assertThrows(IllegalArgumentException.class, () ->
                new BookingPeriod(now, null));
    }
}
