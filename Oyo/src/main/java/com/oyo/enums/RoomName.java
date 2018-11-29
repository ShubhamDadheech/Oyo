package com.oyo.enums;

public enum RoomName {

	Normal("normal"),Deluxe("deluxe"),SuperDeluxe("super deluxe"),Luxury("luxury"),SuperLuxury("super luxury");
	
	private String value;

	private RoomName(String value) {
		this.value = value.toUpperCase();
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value.toUpperCase();
	}
}
