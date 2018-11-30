package com.oyo.entity;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.oyo.dto.HotelDTO;

@Entity
@Table(name = "hotel")
public class Hotel {

	/**
	 * hotel id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "hotel_id")
	private int id;

	/**
	 * hotel Name
	 */
	@Column(name = "hotel_name", nullable = false)
	private String hotelName;

	/**
	 * hotel rating
	 */
	@Column(name = "rating")
	private Double rating;

	/**
	 * hotel address one to one mapping with Address entity
	 */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "address_id", nullable = false)
	private Address address;

	/**
	 * hotel facility one to one mapping with facility entity
	 */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "facility_id", nullable = false)
	private Facility facility;

	/**
	 * one to many mapping with room entity
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "hotel")
	private List<Room> rooms;

	public Hotel() {
	}

	public Hotel(HotelDTO hotelDTO) {

		this.id = hotelDTO.getId();
		this.hotelName = hotelDTO.getHotelName();
		this.rating = hotelDTO.getRating();
		this.address = new Address(hotelDTO.getAddress());
		this.facility = new Facility(hotelDTO.getFacility());

		if (hotelDTO.getRooms() != null && hotelDTO.getRooms().isEmpty() == false) {
			this.rooms = hotelDTO.getRooms().stream().map(Room::new).collect(Collectors.toList());
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

}
