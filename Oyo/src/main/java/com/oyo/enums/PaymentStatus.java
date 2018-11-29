package com.oyo.enums;

public enum PaymentStatus {
	Paid("paid"),UnPaid("unpaid");
	private String value ;

	private PaymentStatus(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value.toUpperCase();
	}
}
