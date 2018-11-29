package com.oyo.dto;

import java.util.List;

import com.oyo.entity.Room;
import com.oyo.enums.RoomName;
import com.oyo.enums.RoomStatus;
import com.oyo.enums.RoomType;

public class RoomDTO {

	private int id;
	private RoomName roomName;
	private RoomType roomType;
	private RoomStatus roomStatus;
	private boolean airCondition;
	private int roomCost;
	private HotelDTO hotel;

	public RoomDTO() {
	}

	public RoomDTO(Room room) {

		this.id = room.getId();
		this.roomName = room.getRoomName();
		this.roomType = room.getRoomType();
		this.roomStatus = room.getRoomStatus();
		this.airCondition = room.isAirCondition();
		this.roomCost = room.getRoomCost();
		// if (room.getHotel() != null) {
		// this.hotel = new HotelDTO(room.getHotel());
		//
		// }
	}

	public RoomDTO(Room room, boolean showHotel) {

		this.id = room.getId();
		this.roomName = room.getRoomName();
		this.roomType = room.getRoomType();
		this.roomStatus = room.getRoomStatus();
		this.airCondition = room.isAirCondition();
		this.roomCost = room.getRoomCost();

		if (showHotel) {
			if (room.getHotel() != null) {
				this.hotel = new HotelDTO(room.getHotel());

			}

		}
	}
	
	public RoomDTO(List<Room> rooms, boolean showHotel) {

		for(Room room : rooms) {
			this.id = room.getId();
			this.roomName = room.getRoomName();
			this.roomType = room.getRoomType();
			this.roomStatus = room.getRoomStatus();
			this.airCondition = room.isAirCondition();
			this.roomCost = room.getRoomCost();

			if (showHotel) {
				if (room.getHotel() != null) {
					this.hotel = new HotelDTO(room.getHotel());

				}

			}
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

	public HotelDTO getHotel() {
		return hotel;
	}

	public void setHotel(HotelDTO hotel) {
		this.hotel = hotel;
	}

}
