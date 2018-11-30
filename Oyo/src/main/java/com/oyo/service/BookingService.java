package com.oyo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oyo.dto.BookingDTO;
import com.oyo.entity.Booking;
import com.oyo.entity.Room;
import com.oyo.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private RoomService roomService;

	public List<BookingDTO> getAllBookings() {
		List<Booking> bookings = bookingRepository.findAll();
		return bookings.stream().map(BookingDTO::new).collect(Collectors.toList());
	}

	/**
	 * get BookingDto by id
	 * 
	 * @param id
	 * @return bookingDto
	 * @throws Exception
	 */
	public BookingDTO getBookingDtoById(int id) throws Exception {
		Booking booking = bookingRepository.findById(id).get();
		if (booking == null) {
			throw new Exception("no booking found on this id");
		}
		BookingDTO bookingDTO = new BookingDTO(booking);
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
		Booking bookings = bookingRepository.findById(id).get();
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
	public BookingDTO createOrUpdateBooking(BookingDTO bookingsDTO) throws Exception {
		Booking bookings = new Booking(bookingsDTO);
		if (bookings.getId() != 0) {
			if (findBookingById(bookings.getId()) == null) {
				throw new Exception("no booking found");
			} else {
				// bookings = findBookingById(bookingsDTO.getId());
				bookings = validateBooking(bookings, bookingsDTO);
				bookingRepository.save(bookings);
				return getBookingDtoById(bookings.getId());
			}
		} else {
			bookings = validateBooking(bookings, bookingsDTO);
			bookingRepository.save(bookings);
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
	public Booking validateBooking(Booking booking, BookingDTO bookingsDTO) throws Exception {

		if (booking.getRooms() == null && booking.getRooms().isEmpty()) {
			throw new Exception("room cannot be null provide room id");
		}
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
		 * 
		 */
		// List<Booking> allBookings = bookingRepository.findAll();
		// List<Booking> newBooking =new ArrayList();
		// for(Booking book: allBookings) {
		// if(book.get)
		// }
		/**
		 * validate all room which is add in list must be same hotel
		 */
		ArrayList<Room> listOfRooms = new ArrayList<Room>();
		List<Integer> listOfHotelId = new ArrayList<Integer>();

		// booking.getRooms().forEach(id -> {
		// Room room = roomService.findRoomById1(id.getId());
		// listOfRooms.add(room);
		// listOfHotelId.add(room.getHotel().getId());
		// });

		for (Room b : booking.getRooms()) {
			int i = b.getId();
			Room room = roomService.findRoomById1(i);
			listOfRooms.add(room);
			listOfHotelId.add(room.getHotel().getId());
		}

		boolean allEqualHotel = new HashSet<Integer>(listOfHotelId).size() <= 1;
		if (!allEqualHotel) {
			throw new Exception("all room must be same hotel");
		}
		booking.setRooms(listOfRooms);
		return booking;

	}

	/**
	 * delete all booking
	 */
	public void deleteAllBooking() {
		bookingRepository.deleteAll();
	}

	/**
	 * delete booking by id
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteBookingById(int id) throws Exception {
		Booking bookings = bookingRepository.findById(id).get();
		if (bookings == null) {
			throw new Exception("no booking found on this id");
		}
		bookingRepository.delete(bookings);
	}

	/**
	 * find list of all booking by room id
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<BookingDTO> getAllBookingsByRoomId(int id) throws Exception {

		Room room = roomService.findRoomById(id);
		if (room == null) {
			throw new Exception("no room found on this room id");
		}

		List<Booking> bookings = bookingRepository.findAll().stream().filter(t -> t.getRooms().contains(room))
				.collect(Collectors.toList());
//		List<Booking> bookings = bookingRepository.findAll().stream().filter(t -> t.getRooms().stream().anyMatch(i-> i.getId()==id))
//				.collect(Collectors.toList());
		
		if (bookings == null) {
			throw new Exception("no booking found on this room id");
		}

		return bookings.stream().map(BookingDTO::new).collect(Collectors.toList());

	}

}
