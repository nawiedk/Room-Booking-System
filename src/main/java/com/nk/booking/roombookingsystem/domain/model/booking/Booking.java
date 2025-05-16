package com.nk.booking.roombookingsystem.domain.model.booking;

import java.util.Objects;
import java.util.UUID;

public class Booking {
    private final UUID id;
    private final UUID userId;
    private final UUID roomId;
    private final BookingPeriod period;
    private BookingStatus status;

    public Booking(UUID id, UUID userId, UUID roomId, BookingPeriod period) {
        this.id = Objects.requireNonNull(id);
        this.userId = Objects.requireNonNull(userId);
        this.roomId = Objects.requireNonNull(roomId);
        this.period = Objects.requireNonNull(period);
        this.status = BookingStatus.BOOKED;
    }

    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getRoomId() {
        return roomId;
    }

    public BookingPeriod getPeriod() {
        return period;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void cancel() {
        if (status == BookingStatus.CANCELED) {
            throw new IllegalStateException("Booking is already canceled.");
        }
        this.status = BookingStatus.CANCELED;
    }

    public void complete() {
        if (status != BookingStatus.BOOKED) {
            throw new IllegalStateException("Only active bookings can be completed.");
        }
        this.status = BookingStatus.COMPLETED;
    }
}
