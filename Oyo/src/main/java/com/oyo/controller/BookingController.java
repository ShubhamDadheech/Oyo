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

import com.oyo.dto.BookingDTO;
import com.oyo.service.BookingService;


@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	/**
	 * get list of All BookingDto
	 * @return list of BookingDto
	 */
	
	@GetMapping
	public List<BookingDTO> getAllBooking() {
		return bookingService.getAllBookings();
	}
	
	/**
	 * get bookingDto by id
	 * @param id
	 * @return BookingDto 
	 * @throws Exception if booking is not available on given id
	 */
	@GetMapping("/{id}")
	public BookingDTO getBookingById(@PathVariable(name = "id") int id) throws Exception {
		return bookingService.getBookingDtoById(id);
	}

	/**
	 * create or update booking
	 * @param bookingDTO
	 * @return
	 * @throws Exception 
	 */
	@PostMapping
	public BookingDTO createOrUpdateBooking(@RequestBody BookingDTO bookingDTO) throws Exception {
		return bookingService.createOrUpdateBooking(bookingDTO);
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
	
	@GetMapping("/room/{id}")
	public List<BookingDTO> getAllBookingsByRoomId (@PathVariable(name = "id") int id) throws Exception{
		return bookingService.getAllBookingsByRoomId(id);
		
	}
	
}
