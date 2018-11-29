package com.oyo.dto;

import com.oyo.entity.Facility;

public class FacilityDTO {

	private int id;
	private boolean breakFastFree;
	private boolean hotWater;
	private boolean lift;
	private boolean powerBackup;
	private boolean swimmingPool;
	private boolean restaurant;
	
	

	
	public FacilityDTO() {
		
	}

	public FacilityDTO(Facility facility) {
		
		this.id = facility.getId();
		this.breakFastFree = facility.isBreakFastFree();
		this.hotWater = facility.isHotWater();
		this.lift = facility.isLift();
		this.powerBackup = facility.isPowerBackup();
		this.swimmingPool = facility.isSwimmingPool();
		this.restaurant = facility.isRestaurant();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isBreakFastFree() {
		return breakFastFree;
	}

	public void setBreakFastFree(boolean breakFastFree) {
		this.breakFastFree = breakFastFree;
	}

	public boolean isHotWater() {
		return hotWater;
	}

	public void setHotWater(boolean hotWater) {
		this.hotWater = hotWater;
	}

	public boolean isLift() {
		return lift;
	}

	public void setLift(boolean lift) {
		this.lift = lift;
	}

	public boolean isPowerBackup() {
		return powerBackup;
	}

	public void setPowerBackup(boolean powerBackup) {
		this.powerBackup = powerBackup;
	}

	public boolean isSwimmingPool() {
		return swimmingPool;
	}

	public void setSwimmingPool(boolean swimmingPool) {
		this.swimmingPool = swimmingPool;
	}

	public boolean isRestaurant() {
		return restaurant;
	}

	public void setRestaurant(boolean restaurant) {
		this.restaurant = restaurant;
	}

	
}