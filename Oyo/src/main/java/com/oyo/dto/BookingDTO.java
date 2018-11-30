package com.oyo.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.oyo.entity.Booking;
import com.oyo.enums.PaymentStatus;

public class BookingDTO {

	private int id;
	private Date bookingDate;
	private PaymentStatus bookingPaymentStatus;
	private Date bookingFrom;
	private Date bookingTo;
	private int numberOfPerson;
	private List<RoomDTO> roomsDto;

	public BookingDTO() {

	}

	public BookingDTO(Booking bookings) {

		this.id = bookings.getId();

		this.bookingDate = bookings.getBookingDate();
		this.bookingPaymentStatus = bookings.getBookingPaymentStatus();
		this.bookingFrom = bookings.getBookingFrom();
		this.bookingTo = bookings.getBookingTo();

		this.numberOfPerson = bookings.getNumberOfPerson();
		this.roomsDto = bookings.getRooms().stream().map(dt -> new RoomDTO(bookings.getRooms(), true)).collect(Collectors.toList());
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public PaymentStatus getBookingPaymentStatus() {
		return bookingPaymentStatus;
	}

	public void setBookingPaymentStatus(PaymentStatus bookingPaymentStatus) {
		this.bookingPaymentStatus = bookingPaymentStatus;
	}

	public Date getBookingFrom() {
		return bookingFrom;
	}

	public void setBookingFrom(Date bookingFrom) {
		this.bookingFrom = bookingFrom;
	}

	public Date getBookingTo() {
		return bookingTo;
	}

	public void setBookingTo(Date bookingTo) {
		this.bookingTo = bookingTo;
	}

	public int getNumberOfPerson() {
		return numberOfPerson;
	}

	public void setNumberOfPerson(int numberOfPerson) {
		this.numberOfPerson = numberOfPerson;
	}

	public List<RoomDTO> getRoomsDto() {
		return roomsDto;
	}

	public void setRoomsDto(List<RoomDTO> roomsDto) {
		this.roomsDto = roomsDto;
	}

}
