package com.hotel.vinateg.Vintage.service.interfac;

import com.hotel.vinateg.Vintage.dto.Response;
import com.hotel.vinateg.Vintage.entity.Booking;

public interface IBookingService {

    Response saveBooking(Long rooId, Long userId, Booking bookingRequest);
    Response findBookingByConfirmationCode(String confirmationCode);
    Response getAllBookings();
    Response cancelBooking(Long bookingId);
}