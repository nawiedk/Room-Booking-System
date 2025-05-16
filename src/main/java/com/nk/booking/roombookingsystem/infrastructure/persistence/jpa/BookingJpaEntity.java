package com.nk.booking.roombookingsystem.infrastructure.persistence.jpa;

import com.nk.booking.roombookingsystem.domain.model.booking.BookingStatus;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "bookings")
public class BookingJpaEntity {

    @Id
    private UUID id;

    private UUID userId;
    private UUID roomId;
    private LocalDateTime start;
    private LocalDateTime end;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    public BookingJpaEntity() {
    }

    public BookingJpaEntity(UUID id, UUID userId, UUID roomId, LocalDateTime start, LocalDateTime end, BookingStatus status) {
        this.id = id;
        this.userId = userId;
        this.roomId = roomId;
        this.start = start;
        this.end = end;
        this.status = status;
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

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public BookingStatus getStatus() {
        return status;
    }
}