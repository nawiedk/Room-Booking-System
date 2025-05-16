package com.nk.booking.roombookingsystem.application.service;

import com.nk.booking.roombookingsystem.application.dto.BookingDTO;
import com.nk.booking.roombookingsystem.domain.model.booking.Booking;
import com.nk.booking.roombookingsystem.domain.model.booking.BookingStatus;
import com.nk.booking.roombookingsystem.domain.repository.BookingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookingServiceTest {

    private BookingRepository bookingRepository;
    private BookingService bookingService;

    @BeforeEach
    void setUp() {
        bookingRepository = mock(BookingRepository.class);
        bookingService = new BookingService(bookingRepository);
    }

    @Test
    void shouldCreateBookingAndSaveIt() {
        UUID userId = UUID.randomUUID();
        UUID roomId = UUID.randomUUID();
        LocalDateTime start = LocalDateTime.of(2024, 6, 1, 10, 0);
        LocalDateTime end = LocalDateTime.of(2024, 6, 1, 11, 0);

        BookingDTO dto = bookingService.createBooking(userId, roomId, start, end);

        assertNotNull(dto.getId());
        assertEquals(userId, dto.getUserId());
        assertEquals(roomId, dto.getRoomId());
        assertEquals(start, dto.getStart());
        assertEquals(end, dto.getEnd());
        assertEquals(BookingStatus.BOOKED, dto.getStatus());

        ArgumentCaptor<Booking> captor = ArgumentCaptor.forClass(Booking.class);
        verify(bookingRepository, times(1)).save(captor.capture());

        Booking saved = captor.getValue();
        assertEquals(userId, saved.getUserId());
        assertEquals(roomId, saved.getRoomId());
        assertEquals(start, saved.getPeriod().getStart());
        assertEquals(end, saved.getPeriod().getEnd());
        assertEquals(BookingStatus.BOOKED, saved.getStatus());
    }
}
