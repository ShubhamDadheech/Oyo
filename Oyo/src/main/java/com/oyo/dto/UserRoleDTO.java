package com.oyo.dto;

import com.oyo.entity.UserRole;

public class UserRoleDTO {

	private int id;
    private String roleName;
    
    

	public UserRoleDTO(UserRole userRole) {
		
		this.id = userRole.getId();
		this.roleName = userRole.getRoleName();
	}

	
	
	public UserRoleDTO() {
		;
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
