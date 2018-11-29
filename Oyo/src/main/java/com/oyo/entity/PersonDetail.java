package com.oyo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.joda.time.LocalDate;

import com.oyo.dto.PersonalDetailDTO;
import com.oyo.enums.Gender;

@Entity
@Table(name="person_detail")
public class PersonDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;
	
	@Column(name = "aadhar_card_number")
	private String aadharCardNumber;
	
	@Column(name = "gender")
	private Gender gender;
	
	@Column(name = "contact_number")
	private int contactNumber;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "address_id",nullable = false)
	private Address address;
	
	

	public PersonDetail() {
		
	}

	public PersonDetail(PersonalDetailDTO personalDetailDTO) {
		this.id = personalDetailDTO.getId();
		this.name = personalDetailDTO.getName();
		this.dateOfBirth = personalDetailDTO.getDateOfBirth();
		this.aadharCardNumber = personalDetailDTO.getAadharCardNumber();
		this.gender = personalDetailDTO.getGender();
		this.contactNumber = personalDetailDTO.getContactNumber();
		this.address = new Address(personalDetailDTO.getAddressDTO());
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
