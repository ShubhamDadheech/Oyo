package com.oyo.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.oyo.entity.Hotel;


public class HotelDTO {

	private int id;
	private String hotelName;
	private Double rating;
	private AddressDTO address;
	private FacilityDTO facility;
	private List<RoomDTO> rooms; 

	
	public HotelDTO() {}

	public HotelDTO(Hotel hotel,boolean showRooms) {
		
		this.id = hotel.getId();
		this.hotelName = hotel.getHotelName();
		this.rating = hotel.getRating();
		this.address = new AddressDTO(hotel.getAddress());
		this.facility = new FacilityDTO(hotel.getFacility());
	
		if(showRooms) {
			this.rooms = hotel.getRooms().stream().map(RoomDTO::new).collect(Collectors.toList());
		}
		

	}

	public HotelDTO(Hotel hotel) {
		this.id = hotel.getId();
		this.hotelName = hotel.getHotelName();
		this.rating = hotel.getRating();
		this.address = new AddressDTO(hotel.getAddress());
		this.facility = new FacilityDTO(hotel.getFacility());
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

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}


	public FacilityDTO getFacility() {
		return facility;
	}

	public void setFacility(FacilityDTO facility) {
		this.facility = facility;
	}

	public List<RoomDTO> getRooms() {
		return rooms;
	}

	public void setRooms(List<RoomDTO> rooms) {
		this.rooms = rooms;
	}

	
}
