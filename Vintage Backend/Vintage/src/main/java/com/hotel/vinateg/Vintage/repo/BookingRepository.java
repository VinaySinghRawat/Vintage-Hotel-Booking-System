package com.hotel.vinateg.Vintage.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.vinateg.Vintage.entity.Booking;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    Optional<Booking> findByBookingConfirmationCode(String confirmationCode);
}
