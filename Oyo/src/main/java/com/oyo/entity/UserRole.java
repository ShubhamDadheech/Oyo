package com.oyo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.oyo.dto.UserRoleDTO;

@Entity
@Table(name="user_role")
public class UserRole {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="role_name")
	 private String roleName;

	public UserRole(UserRoleDTO userRoleDto) {
		this.id = userRoleDto.getId();
		this.roleName = userRoleDto.getRoleName();
	}

	
	
	public UserRole() {
		
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
