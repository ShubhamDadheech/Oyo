package com.oyo.entity;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.oyo.dto.BookingDTO;
import com.oyo.dto.RoomDTO;
import com.oyo.enums.PaymentStatus;

@Entity
@Table(name = "booking ")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "booking_id")
	private int id;

	@Column(name = "booking_date")
	@Temporal(TemporalType.DATE)
	private Date bookingDate;

	@Column(name = "booking_payment_status")
	private PaymentStatus bookingPaymentStatus;

//	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd ")
	@Column(name = "booking_to")
	@Temporal(TemporalType.DATE)
	private Date bookingTo;

//	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd ")
	@Column(name = "booking_from")
	@Temporal(TemporalType.DATE)
	private Date bookingFrom;

	@Column(name = "number_of_person")
	private int numberOfPerson;

	@ManyToMany(fetch =FetchType.EAGER)
	@JoinTable(name = "booking_rooms", joinColumns = @JoinColumn(name = "booking_id"), inverseJoinColumns = @JoinColumn(name = "id"))
	private List<Room> rooms;

	public Booking() {

	}

	public Booking(BookingDTO bookingsDTO) {

		this.id = bookingsDTO.getId();
		this.bookingDate = new Date();
		this.bookingPaymentStatus = bookingsDTO.getBookingPaymentStatus();
		this.bookingTo = bookingsDTO.getBookingTo();
		this.bookingFrom = bookingsDTO.getBookingFrom();
		this.numberOfPerson = bookingsDTO.getNumberOfPerson();
		this.rooms = bookingsDTO.getRoomsDto().stream().map(dt -> new Room(bookingsDTO.getRoomsDto(), true)).collect(Collectors.toList());
		
		
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

	public Date getBookingTo() {
		return bookingTo;
	}

	public void setBookingTo(Date bookingTo) {
		this.bookingTo = bookingTo;
	}

	public Date getBookingFrom() {
		return bookingFrom;
	}

	public void setBookingFrom(Date bookingFrom) {
		this.bookingFrom = bookingFrom;
	}

	public int getNumberOfPerson() {
		return numberOfPerson;
	}

	public void setNumberOfPerson(int numberOfPerson) {
		this.numberOfPerson = numberOfPerson;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

//	public static void main(String[] args) {
//		LocalDate d = new LocalDate();
//		String s = "2018-12-28";
//		LocalDate s1 = LocalDate.parse(s);
//		System.out.println(s1);
//	}
}
