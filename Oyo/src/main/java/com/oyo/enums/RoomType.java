package com.oyo.enums;

public enum RoomType {
Single("singlebed"),Double("doublebed"),Triple("triplebed");
	
	private String value;

	private RoomType(String value) {
		this.value = value.toUpperCase();
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value.toUpperCase();
	}
	
}
