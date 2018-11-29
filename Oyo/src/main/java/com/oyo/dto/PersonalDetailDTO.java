package com.oyo.dto;

import org.joda.time.LocalDate;

import com.oyo.entity.PersonDetail;
import com.oyo.enums.Gender;

public class PersonalDetailDTO {

	private int id;
	private String name;
	private LocalDate dateOfBirth;
	private String aadharCardNumber;
	private Gender gender;
	private int contactNumber;
	private AddressDTO addressDTO;

	public PersonalDetailDTO() {

	}

	public PersonalDetailDTO(PersonDetail personDetail) {

		this.id = personDetail.getId();
		this.name = personDetail.getName();
		this.dateOfBirth = personDetail.getDateOfBirth();
		this.aadharCardNumber = personDetail.getAadharCardNumber();
		this.gender = personDetail.getGender();
		this.contactNumber = personDetail.getContactNumber();
		this.addressDTO = new AddressDTO(personDetail.getAddress());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAadharCardNumber() {
		return aadharCardNumber;
	}

	public void setAadharCardNumber(String aadharCardNumber) {
		this.aadharCardNumber = aadharCardNumber;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	public AddressDTO getAddressDTO() {
		return addressDTO;
	}

	public void setAddressDTO(AddressDTO addressDTO) {
		this.addressDTO = addressDTO;
	}

}
