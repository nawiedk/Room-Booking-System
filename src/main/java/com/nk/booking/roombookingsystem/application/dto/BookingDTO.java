package com.nk.booking.roombookingsystem.application.dto;

import com.nk.booking.roombookingsystem.domain.model.booking.BookingStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class BookingDTO {
    private UUID id;
    private UUID userId;
    private UUID roomId;
    private LocalDateTime start;
    private LocalDateTime end;
    private BookingStatus status;

    public BookingDTO(UUID id, UUID userId, UUID roomId, LocalDateTime start, LocalDateTime end, BookingStatus status) {
        this.id = id;
        this.userId = userId;
        this.roomId = roomId;
        this.start = start;
        this.end = end;
        this.status = status;
    }

    public UUID getId() { return id; }
    public UUID getUserId() { return userId; }
    public UUID getRoomId() { return roomId; }
    public LocalDateTime getStart() { return start; }
    public LocalDateTime getEnd() { return end; }
    public BookingStatus getStatus() { return status; }
}
