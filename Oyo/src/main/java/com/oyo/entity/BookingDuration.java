package com.oyo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.oyo.dto.BookingDurationDTO;

@Entity
@Table(name="booking_duration")
public class BookingDuration {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="booking_form")
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date bookingFrom;
	
	@Column(name="booking_to")
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date bookingTo;
	
	
	public BookingDuration() {}
	
	
	public BookingDuration(BookingDurationDTO bookingDurationDTO) {
		this.id = bookingDurationDTO.getId();
		this.bookingFrom = bookingDurationDTO.getBookingFrom();
		this.bookingTo = bookingDurationDTO.getBookingTo();
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













//
//<dependency>
//<groupId>joda-time</groupId>
//<artifactId>joda-time</artifactId>
//</dependency>
//
//<dependency>
//<groupId>com.fasterxml.jackson.jaxrs</groupId>
//<artifactId>jackson-jaxrs-json-provider</artifactId>
//</dependency>
//
//<dependency>
//<groupId>com.fasterxml.jackson.datatype</groupId>
//<artifactId>jackson-datatype-joda</artifactId>
//</dependency>
//
//<dependency>
//<groupId>org.jadira.usertype</groupId>
//<artifactId>usertype.core</artifactId>
//<version>3.1.0.CR1</version>
//</dependency>







