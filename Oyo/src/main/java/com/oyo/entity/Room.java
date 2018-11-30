package com.oyo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.oyo.dto.RoomDTO;
import com.oyo.enums.RoomName;
import com.oyo.enums.RoomStatus;
import com.oyo.enums.RoomType;

@Entity
@Table(name = "room")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "room_name", nullable = false)
	@Enumerated(EnumType.STRING)
	private RoomName roomName;

	@Column(name = "room_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private RoomType roomType;

	@Column(name = "room_status", nullable = false)
	@Enumerated(EnumType.STRING)
	private RoomStatus roomStatus;

	@Column(name = "air_condition", nullable = false)
	private boolean airCondition;

	@Column(name = "room_cost", nullable = false)
	private int roomCost;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;

	public Room() {
	}

	public Room(RoomDTO roomDto) {

		this.id = roomDto.getId();
		this.roomName = roomDto.getRoomName();
		this.roomType = roomDto.getRoomType();
		this.roomStatus = roomDto.getRoomStatus();
		this.airCondition = roomDto.isAirCondition();
		this.roomCost = roomDto.getRoomCost();

		if (roomDto.getHotel() != null) {
			this.hotel = new Hotel(roomDto.getHotel());
		}

	}

	public Room(List<RoomDTO> roomDto, boolean showHotel) {

		for (RoomDTO roomDTO2 : roomDto) {
			this.id = roomDTO2.getId();
			this.roomName = roomDTO2.getRoomName();
			this.roomType = roomDTO2.getRoomType();
			this.roomStatus = roomDTO2.getRoomStatus();
			this.airCondition = roomDTO2.isAirCondition();
			this.roomCost = roomDTO2.getRoomCost();

			this.hotel = new Hotel(roomDTO2.getHotel());

		}

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RoomName getRoomName() {
		return roomName;
	}

	public void setRoomName(RoomName roomName) {
		this.roomName = roomName;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public RoomStatus getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(RoomStatus roomStatus) {
		this.roomStatus = roomStatus;
	}

	public boolean isAirCondition() {
		return airCondition;
	}

	public void setAirCondition(boolean airCondition) {
		this.airCondition = airCondition;
	}

	public int getRoomCost() {
		return roomCost;
	}

	public void setRoomCost(int roomCost) {
		this.roomCost = roomCost;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}
