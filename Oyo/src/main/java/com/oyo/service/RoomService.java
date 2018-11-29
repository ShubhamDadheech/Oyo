package com.oyo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oyo.dto.HotelDTO;
import com.oyo.dto.RoomDTO;
import com.oyo.entity.Room;
import com.oyo.repository.RoomRepository;

@Service
public class RoomService {

	@Autowired
	private RoomRepository roomRepository;

	/**
	 * get all room
	 * @return
	 */
	public List<RoomDTO> getAllRoom() {
		List<Room> rooms = roomRepository.findAll();
		return rooms.stream().map(dto -> new RoomDTO(dto, true)).collect(Collectors.toList());
	}

	/**
	 * get room by id but it return roomDto
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public RoomDTO getRoomById(int id) throws Exception {

		Room room = roomRepository.findById(id).get();
		if (room == null) {
			throw new Exception("Room not found");
		}
		RoomDTO roomDTO = new RoomDTO(room,true);
		return roomDTO;
	}
	/**
	 * find room by id but it return room entity
	 * @param id
	 * @return room entiy
	 * @throws Exception
	 */
	public Room findRoomById(int id) throws Exception  {
		Room room = roomRepository.findById(id).get();
		if (room == null) {
			throw new Exception("Room not found");
		}
		return room;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 *
	 */
	public Room findRoomById1(int id)  {
		Room room = roomRepository.findById(id).get();
		return room;
	}
	
	/**
	 * to create or update room
	 * @param roomDto
	 * @return roomDto
	 * @throws Exception if room is null
	 */
	public RoomDTO createUpdateRoom(RoomDTO roomDto) throws Exception {
		Room roomnew = findRoomById(roomDto.getId());

		if (roomnew.getId() != 0) {
			if (findRoomById(roomnew.getId()) == null) {
				throw new Exception("User not found");
			} else {
				roomnew = findRoomById(roomDto.getId());
				roomRepository.save(roomnew);
				return getRoomById(roomnew.getId());
			}

		}

		roomRepository.save(roomnew);
		return getRoomById(roomnew.getId());

	}
	/**
	 * delete all room 
	 */

	public void deleteAllRoom() {
		roomRepository.deleteAll();
	}
	/**
	 * delete room by id
	 */
	public void deleteRoomById(int id) throws Exception {
		Room room = findRoomById(id);
		if (room == null) {
			throw new Exception("Room not found");
		}
		roomRepository.delete(room);
	}
	

}
