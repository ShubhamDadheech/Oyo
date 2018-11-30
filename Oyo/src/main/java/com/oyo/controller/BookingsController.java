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
@RequestMapping("/booking")
public class BookingsController {

	@Autowired
	private BookingsService bookingsService;

	/**
	 * get list of All BookingDto
	 * 
	 * @return list of BookingDto
	 */
	@GetMapping
	public List<BookingsDTO> getAllBookings() {
		return bookingsService.getAllBookings();
	}

	/**
	 * get bookDto by id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/{id}")
	public BookingsDTO getBookingById(@PathVariable(name = "id") int id) throws Exception {
		return bookingsService.getBookingDtoById(id);
	}

	/**
	 * create or update booking
	 * 
	 * @param bookingDTO
	 * @return
	 * @throws Exception
	 *             if booking is not found on given id
	 */
	@PostMapping
	public BookingsDTO createOrUpdateBooking(@RequestBody BookingsDTO bookingsDTO) throws Exception {
		return bookingsService.createOrUpdateBooking(bookingsDTO);
	}

	/**
	 * delete all booking
	 */
	@DeleteMapping
	public void deleteAllBooking() {
		bookingsService.deleteAllBooking();
	}

	/**
	 *
	 * @param id
	 * @throws Exception
	 */
	@DeleteMapping("/{id}")
	public void deleteBookingById(@PathVariable(name = "id") int id) throws Exception {
		bookingsService.deleteBookingById(id);
	}
}
