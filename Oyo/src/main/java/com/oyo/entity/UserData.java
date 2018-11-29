package com.oyo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.oyo.dto.UserDataDTO;
import com.oyo.enums.Gender;

@Entity
@Table(name = "user")
public class UserData {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Size(min = 2, message = "Name should have atleast 2 characters")
	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "dob")
	private String DOB;

	@Column(name = "mobile_number", nullable = false)
	private int mobileNumber;

	@Email
	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "role_id")
	private UserRole userRole;

	public UserData(UserDataDTO userDto) {
		this.id = userDto.getId();
		this.name = userDto.getName();
		this.DOB = userDto.getDOB();
		this.mobileNumber = userDto.getMobileNumber();
		this.email = userDto.getEmail();
		this.gender = userDto.getGender();
		this.userRole = new UserRole(userDto.getUserRole());
	}

	public UserData() {

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

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public int getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

}
