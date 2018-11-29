package com.oyo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.oyo.dto.FacilityDTO;

@Entity
@Table(name = "facility")
public class Facility {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="break_fast_free")
	private boolean breakFastFree;
	
	@Column(name="hot_water")
	private boolean hotWater;
	
	@Column(name="lift")
	private boolean lift;

	@Column(name="power_backup")
	private boolean powerBackup;
	
	@Column(name="swimming_pool")
	private boolean swimmingPool;
	
	@Column(name="restaurant")
	private boolean restaurant;

	
	
	
	public Facility() {
		
	}

	public Facility(FacilityDTO facilityDTO) {
		
		this.id = facilityDTO.getId();
		this.breakFastFree = facilityDTO.isBreakFastFree();
		this.hotWater = facilityDTO.isHotWater();
		this.lift = facilityDTO.isLift();
		this.powerBackup = facilityDTO.isPowerBackup();
		this.swimmingPool = facilityDTO.isSwimmingPool();
		this.restaurant = facilityDTO.isRestaurant();
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