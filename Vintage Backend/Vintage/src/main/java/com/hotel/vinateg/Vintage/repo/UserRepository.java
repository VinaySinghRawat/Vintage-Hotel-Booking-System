package com.hotel.vinateg.Vintage.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.vinateg.Vintage.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
}