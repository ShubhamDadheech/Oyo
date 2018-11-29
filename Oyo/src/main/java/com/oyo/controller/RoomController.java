package com.oyo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oyo.dto.RoomDTO;
import com.oyo.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {

	@Autowired
	private RoomService roomService;
	
	@GetMapping
	public List<RoomDTO> getAllRoom(){
		return roomService.getAllRoom();
	}
	
	@GetMapping("/{id}")
	public RoomDTO getRoomById(@PathVariable (name="id") int id) throws Exception {
		
		return roomService.getRoomById(id);
	}
	
	@PostMapping
	public RoomDTO createUpdateRoom(@RequestBody RoomDTO roomDto) throws Exception {
		return roomService.createUpdateRoom(roomDto);
		
	}
	
	@DeleteMapping
	public void deleteAllRoom() {
		roomService.deleteAllRoom();
	}
	
	@DeleteMapping("/{id}")
	public void deleteRoomById(@PathVariable (name="id") int id) throws Exception {
		roomService.deleteRoomById(id);
	}
	

}
