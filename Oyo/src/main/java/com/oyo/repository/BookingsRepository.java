package com.oyo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oyo.entity.Booking;

@Repository
public interface BookingsRepository extends JpaRepository<Booking, Integer> {

}
