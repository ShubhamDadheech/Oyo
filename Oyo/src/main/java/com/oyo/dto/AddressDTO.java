package com.oyo.dto;

import com.oyo.entity.Address;

public class AddressDTO {

	private int id;
	private String streetNumber;
	private String city;
	private String state;
	private String country;
	private String pinCode;

	
	
	
	
	public AddressDTO() {
	
	}

	public AddressDTO(Address address) {
		this.id = address.getId();
		this.streetNumber = address.getStreetNumber();
		this.city = address.getCity();
		this.state = address.getState();
		this.country = address.getCountry();
		this.pinCode = address.getPinCode();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNoumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

}
