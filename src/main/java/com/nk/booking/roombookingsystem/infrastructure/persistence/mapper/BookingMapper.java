package com.nk.booking.roombookingsystem.infrastructure.persistence.mapper;

import com.nk.booking.roombookingsystem.domain.model.booking.Booking;
import com.nk.booking.roombookingsystem.domain.model.booking.BookingPeriod;
import com.nk.booking.roombookingsystem.infrastructure.persistence.jpa.BookingJpaEntity;

public class BookingMapper {

    public static BookingJpaEntity toJpaEntity(Booking booking) {
        return new BookingJpaEntity(
                booking.getId(),
                booking.getUserId(),
                booking.getRoomId(),
                booking.getPeriod().getStart(),
                booking.getPeriod().getEnd(),
                booking.getStatus()
        );
    }

    public static Booking toDomain(BookingJpaEntity entity) {
        return new Booking(
                entity.getId(),
                entity.getUserId(),
                entity.getRoomId(),
                new BookingPeriod(entity.getStart(), entity.getEnd())
        );
    }
}
