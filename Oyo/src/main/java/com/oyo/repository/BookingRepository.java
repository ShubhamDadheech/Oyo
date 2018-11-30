package com.oyo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oyo.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

	
	
}
