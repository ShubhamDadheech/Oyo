package com.oyo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oyo.dto.BookingsDTO;
import com.oyo.service.BookingsService;


@RestController
@RequestMapping(name = "/booking")
public class BookingController {

	@Autowired
	private BookingsService bookingService;

	/**
	 * get list of All BookingDto
	 * @return list of BookingDto
	 */
	
	@GetMapping
	public List<BookingsDTO> getAllBooking() {
		return bookingService.getAllBookings();
	}
	
	/**
	 * get bookingDto by id
	 * @param id
	 * @return BookingDto 
	 * @throws Exception if booking is not available on given id
	 */
	@GetMapping("/{id}")
	public BookingsDTO getBookingById(@PathVariable(name = "id") int id) throws Exception {
		return bookingService.getBookingDtoById(id);
	}

	/**
	 * create or update booking
	 * @param bookingDTO
	 * @return
	 */
	@PostMapping
	public BookingsDTO createOrUpdateBooking(@RequestBody BookingsDTO bookingDTO) {
		return bookingDTO;
	}

	/**
	 * delete all booking
	 */
	@DeleteMapping
	public void deleteAllBooking() {
		bookingService.deleteAllBooking();
	}

	/**
	 * 
	 * @param id
	 * @throws Exception
	 */
	@DeleteMapping("/{id}")
	public void deleteBookingById(@PathVariable(name = "id") int id) throws Exception {
		bookingService.deleteBookingById(id);
	}
}
