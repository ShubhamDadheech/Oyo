package com.oyo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oyo.dto.BookingsDTO;
import com.oyo.entity.Booking;
import com.oyo.entity.Room;
import com.oyo.repository.BookingsRepository;

@Service
public class BookingsService {

	@Autowired
	private BookingsRepository bookingsRepository;

	@Autowired
	private RoomService roomService;

	public List<BookingsDTO> getAllBookings() {
		List<Booking> bookings = bookingsRepository.findAll();
		return bookings.stream().map(BookingsDTO::new).collect(Collectors.toList());
	}

	/**
	 * get BookingDto by id
	 * 
	 * @param id
	 * @return bookingDto
	 * @throws Exception
	 */
	public BookingsDTO getBookingDtoById(int id) throws Exception {
		Booking booking = bookingsRepository.findById(id).get();
		if (booking == null) {
			throw new Exception("no booking found on this id");
		}
		BookingsDTO bookingDTO = new BookingsDTO(booking);
		return bookingDTO;
	}

	/**
	 * get booking by id
	 * 
	 * @param id
	 * @return booking
	 * @throws Exception
	 */
	public Booking findBookingById(int id) throws Exception {
		Booking bookings = bookingsRepository.findById(id).get();
		if (bookings == null) {
			throw new Exception("no booking found on this id");
		}
		return bookings;
	}

	/**
	 * create or update booking
	 * 
	 * @param bookingDTO
	 * @return BookingDto
	 * @throws Exception
	 */
	public BookingsDTO createOrUpdateBooking(BookingsDTO bookingsDTO) throws Exception {
		Booking bookings = new Booking(bookingsDTO);
		if (bookings.getId() != 0) {
			if (findBookingById(bookings.getId()) == null) {
				throw new Exception("no booking found");
			} else {
				// bookings = findBookingById(bookingsDTO.getId());
				bookings = validateBooking(bookings, bookingsDTO);
				bookingsRepository.save(bookings);
				return getBookingDtoById(bookings.getId());
			}
		} else {
			bookings = validateBooking(bookings, bookingsDTO);
			bookingsRepository.save(bookings);
			return getBookingDtoById(bookings.getId());
		}

	}

	/**
	 * check validation on booking
	 * 
	 * @param booking
	 * @param bookingsDTO
	 * @return
	 * @throws Exception
	 */
	public Booking validateBooking(Booking booking, BookingsDTO bookingsDTO) throws Exception {

		if (booking.getBookingTo().after(booking.getBookingDate())
				|| booking.getBookingFrom().after(booking.getBookingDate())) {
			if (booking.getBookingFrom().before(booking.getBookingTo())) {
				booking.setBookingFrom(bookingsDTO.getBookingFrom());
				booking.setBookingTo(bookingsDTO.getBookingTo());

			} else {
				throw new Exception("Booking To date must be greater then Booking From date");
			}

		} else {
			throw new Exception("Both to date and from date must be greater than current date");
		}

		/**
		 * validate all room which is add in list must be same hotel
		 */
		List<Room> listOfRooms = new ArrayList<>();
		List<Integer> listOfHotelId = new ArrayList<>();
				
				booking.getRooms().forEach(id -> {
			int i = id.getId();
			Room room = roomService.findRoomById1(i);
			if(room !=null) {
			listOfRooms.add(room);
			}else {
				
				
			}
			});

				//https://github.com/ShubhamDadheech/oyo-spring-boot

		// List<Integer> listOfHotelId = new ArrayList<>();
		// for(Room room :listOfRooms) {
		// int id = room.getHotel().getId();
		// listOfHotelId.add(id);
		// }
		//
		// boolean allEqualHotel = new HashSet<Integer>(listOfHotelId).size() <= 1;
		// if(!allEqualHotel) {
		// throw new Exception("all room must be same hotel");
		// }

		return booking;

	}

	/**
	 * delete all booking
	 */
	public void deleteAllBooking() {
		bookingsRepository.deleteAll();
	}

	/**
	 * delete booking by id
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteBookingById(int id) throws Exception {
		Booking bookings = bookingsRepository.findById(id).get();
		if (bookings == null) {
			throw new Exception("no booking found on this id");
		}
		bookingsRepository.delete(bookings);
	}

}
