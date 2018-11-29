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

import com.oyo.dto.UserDataDTO;
import com.oyo.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * @return list of all user
	 */
	@GetMapping
	public List<UserDataDTO> getAllUsers() {

		return userService.getAllUsers();
	}

	/**
	 * @param id
	 * @return user of particular id
	 * @throws Exception if user is not found of given id
	 */
	@GetMapping("/{id}")
	public UserDataDTO getUserById(@PathVariable(name = "id") int id) throws Exception {

		return userService.getUserByID(id);
	}

	/**
	 * @param user
	 * @return userDataDto
	 * @throws Exception
	 */
	@PostMapping
	public UserDataDTO createOrUpdateUser(@RequestBody UserDataDTO user ) throws Exception{
		
		return userService.createOrUpdateUser(user);
	}
	
	/**
	 * @param id
	 * @throws Exception 
	 * delete user by Id
	 */
	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable(name="id") int id) throws Exception {
		
		 userService.deleteUserById(id);
	}
	
	/**
	 * delete all user  
	 */
	@DeleteMapping
	public void deleteAllUsers() {
		userService.deleteAllUsers();
	}
}
