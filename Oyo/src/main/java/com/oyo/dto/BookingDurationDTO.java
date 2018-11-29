package com.oyo.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.oyo.entity.BookingDuration;

public class BookingDurationDTO {

	private int id;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
	private Date bookingFrom;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
	private Date bookingTo;

	public BookingDurationDTO() {}
	
	
	public BookingDurationDTO(BookingDuration bookingDuration) {
		
		this.id = bookingDuration.getId();
		this.bookingFrom = bookingDuration.getBookingFrom();
		this.bookingTo = bookingDuration.getBookingTo();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
}
