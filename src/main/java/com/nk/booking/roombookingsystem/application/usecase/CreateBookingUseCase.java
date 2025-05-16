package com.nk.booking.roombookingsystem.application.usecase;

import com.nk.booking.roombookingsystem.application.dto.BookingDTO;

import java.time.LocalDateTime;
import java.util.UUID;

public interface CreateBookingUseCase {
    BookingDTO createBooking(UUID userId, UUID roomId, LocalDateTime start, LocalDateTime end);
}
