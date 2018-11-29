package com.oyo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oyo.dto.UserDataDTO;
import com.oyo.entity.UserData;
import com.oyo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * get list of all use
	 * 
	 * @return list of all userDataDto
	 */
	public List<UserDataDTO> getAllUsers() {

		List<UserData> userDatas = userRepository.findAll();
		List<UserDataDTO> userDto = userDatas.stream().map(UserDataDTO::new).collect(Collectors.toList());
		return userDto;
	}

	/**
	 * get user by id
	 * 
	 * @param id
	 * @return userdataDTO
	 * @throws Exception
	 *    if user is not found on given id
	 */
	public UserDataDTO getUserByID(int id) throws Exception {
		UserData userData = userRepository.findById(id).get();
		if (userData == null) {
			throw new Exception("User not found");
		}
		UserDataDTO userDto = new UserDataDTO(userData);
		return userDto;
	}

	/**
	 * get user by id
	 * 
	 * @param id
	 * @return userdataEntity
	 * @throws Exception
	 *             if user is not found on given id
	 */
	public UserData findUserById(int id) throws Exception {
		UserData userData = userRepository.findById(id).get();
		if (userData == null) {
			throw new Exception("User not found");
		}
		return userData;
	}

	/**
	 * @param user
	 * @return user
	 * @throws Exception
	 */
	public UserDataDTO createOrUpdateUser(UserDataDTO userDto) throws Exception {

		UserData usernew = new UserData(userDto);
		if (usernew.getId() != 0) {
			if (findUserById(usernew.getId()) == null) {
				throw new Exception("User not found");
			} else {
				usernew = findUserById(userDto.getId());
				validateUser(usernew,userDto);
				userRepository.save(usernew);
				return getUserByID(usernew.getId());
			}

		}else {
			userRepository.save(usernew);
			return userDto;
	
		}

	
	}
	
	/**
	 * @param usernew
	 * @param userDto
	 * @return UserData
	 * @throws Exception
	 */
	public UserData validateUser(UserData usernew, UserDataDTO userDto) throws Exception {
		
		if (userDto.getName() != null) {
			usernew.setName(userDto.getName());
		}
		else {
			throw new Exception("name must not null");
		}
		if (userDto.getDOB() != null) {
			usernew.setDOB(userDto.getDOB());
		}
		else {
			throw new Exception("date of birth must not null");
		}
		if (userDto.getMobileNumber() != 0) {
			usernew.setMobileNumber(userDto.getMobileNumber());
		}
		else {
			throw new Exception("Mobile number must not null");
		}
		if (userDto.getEmail() != null) {
			usernew.setEmail(userDto.getEmail());
		}
		else {
			throw new Exception("email must not null");
		}
		if (userDto.getGender() != null) {
			usernew.setGender(userDto.getGender());
		}
		else {
			throw new Exception("gender must not null");
		}
		return usernew;
	}

	/**
	 * delete user by id
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteUserById(int id) throws Exception {
		UserData user = findUserById(id);
		if (user == null) {
			throw new Exception("User not found");
		}
		userRepository.delete(user);

	}

	/**
	 * delete all user
	 */
	public void deleteAllUsers() {
		userRepository.deleteAll();
	}
}
