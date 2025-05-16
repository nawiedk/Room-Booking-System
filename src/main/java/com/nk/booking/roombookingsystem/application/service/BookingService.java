package com.nk.booking.roombookingsystem.application.service;

import com.nk.booking.roombookingsystem.application.dto.BookingDTO;
import com.nk.booking.roombookingsystem.application.usecase.CreateBookingUseCase;
import com.nk.booking.roombookingsystem.domain.model.booking.Booking;
import com.nk.booking.roombookingsystem.domain.model.booking.BookingPeriod;
import com.nk.booking.roombookingsystem.domain.repository.BookingRepository;

import java.util.UUID;

import java.time.LocalDateTime;

public class BookingService implements CreateBookingUseCase {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public BookingDTO createBooking(UUID userId, UUID roomId, LocalDateTime start, LocalDateTime end) {
        BookingPeriod period = new BookingPeriod(start, end);
        Booking booking = new Booking(UUID.randomUUID(), userId, roomId, period);
        bookingRepository.save(booking);

        return new BookingDTO(
                booking.getId(),
                booking.getUserId(),
                booking.getRoomId(),
                booking.getPeriod().getStart(),
                booking.getPeriod().getEnd(),
                booking.getStatus()
        );
    }
}
