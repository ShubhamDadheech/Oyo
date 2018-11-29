package com.oyo.enums;

public enum Gender {

	Male("male"),Female("female");
	

	private String value;

	private Gender(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
