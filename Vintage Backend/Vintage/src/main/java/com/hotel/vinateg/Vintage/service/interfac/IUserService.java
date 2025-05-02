package com.hotel.vinateg.Vintage.service.interfac;

import com.hotel.vinateg.Vintage.dto.LoginRequest;
import com.hotel.vinateg.Vintage.dto.Response;
import com.hotel.vinateg.Vintage.entity.User;

public interface IUserService {

    Response register(User user);
    Response login(LoginRequest loginRequest);
    Response getAllUsers();
    Response getUSerBookingHistory(String userId);
    Response deleteUser(String userId);
    Response getUserById(String userId);
    Response getMyInfo(String email);
}