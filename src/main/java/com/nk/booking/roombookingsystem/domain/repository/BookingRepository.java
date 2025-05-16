package com.nk.booking.roombookingsystem.domain.repository;

import com.nk.booking.roombookingsystem.domain.model.booking.Booking;

public interface BookingRepository {
    void save(Booking booking);
}
