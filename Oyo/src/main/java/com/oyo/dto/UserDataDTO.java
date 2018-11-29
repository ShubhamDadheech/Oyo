package com.oyo.dto;

import com.oyo.entity.UserData;
import com.oyo.enums.Gender;

public class UserDataDTO {

	private int id;
	private String name;
	private String dateOfBirth;
	private int mobileNumber;
	private String email;
	private Gender gender;
	private UserRoleDTO userRole;

	
	
	
	public UserDataDTO() {
		
	}

	public UserDataDTO(UserData userdata) {
		this.id = userdata.getId();
		this.name = userdata.getName();
		this.dateOfBirth = userdata.getDOB();
		this.mobileNumber = userdata.getMobileNumber();
		this.email = userdata.getEmail();
		this.gender = userdata.getGender();
		this.userRole = new UserRoleDTO(userdata.getUserRole());
	}

	

	public UserDataDTO(int id, String name, String dateOfBirth, int mobileNumber, String email, Gender gender,
			UserRoleDTO userRole) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.gender = gender;
		this.userRole = userRole;
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
		return dateOfBirth;
	}

	public void setDOB(String dOB) {
		dateOfBirth = dOB;
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

	public UserRoleDTO getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRoleDTO userRole) {
		this.userRole = userRole;
	}


}
