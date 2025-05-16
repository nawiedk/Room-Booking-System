package com.nk.booking.roombookingsystem.infrastructure.persistence.jpa;

import com.nk.booking.roombookingsystem.domain.model.booking.Booking;
import com.nk.booking.roombookingsystem.domain.repository.BookingRepository;
import com.nk.booking.roombookingsystem.infrastructure.persistence.mapper.BookingMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JpaBookingRepositoryAdapter implements BookingRepository {

    private final BookingJpaRepository jpaRepository;

    public JpaBookingRepositoryAdapter(BookingJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void save(Booking booking) {
        jpaRepository.save(BookingMapper.toJpaEntity(booking));
    }
}