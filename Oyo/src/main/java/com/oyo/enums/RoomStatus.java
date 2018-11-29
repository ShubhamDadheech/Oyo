package com.oyo.enums;

public enum RoomStatus {

Available("available"),Notavailable("not available"),Undermaintenance("maintenance");
	
	private String value;

	private RoomStatus(String value) {
		this.value = value.toUpperCase();
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value.toUpperCase();
	}
	
}
