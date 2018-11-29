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

import com.oyo.dto.HotelDTO;
import com.oyo.service.HotelServices;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelServices hotelServices;

	/**
	 * @return list of all hotelDTO
	 */
	@GetMapping
	public List<HotelDTO> getAllHotels() {

		return hotelServices.getAllHotelList();
	}

	/**
	 * @param id
	 * @return hotel object of particular id
	 * @throws Exception
	 *             when hotel is not found by given id
	 */
	@GetMapping("/{id}")
	public HotelDTO getHotelById(@PathVariable(name = "id") int id) throws Exception {
		return hotelServices.getHotelById(id);
	}

	/**
	 * @param hotel
	 * @return Hotel object
	 * @throws Exception
	 */
	@PostMapping
	public HotelDTO createUpdateHotel(@RequestBody HotelDTO hotelDTO) throws Exception {
		return hotelServices.createUpdateHotel(hotelDTO);
	}

	/**
	 * delete all hotel
	 */
	@DeleteMapping
	public void deleteAllHotel() {
		hotelServices.deleteAllHotel();
	}

	/**
	 * @param id
	 * @throws Exception
	 */
	@DeleteMapping("/{id}")
	public void deleteHotelByID(@PathVariable(name = "id") int id) throws Exception {
		hotelServices.deletehotelById(id);
	}
	
	/**
	 * 
	 * @param city
	 * @return
	 */
	@GetMapping("/city/{city}")
	public List<HotelDTO> getHotelByCity(@PathVariable (name="city") String city){
		return hotelServices.getHotelByCity(city);
	}
	
	@GetMapping("/cost/{min}/{max}")
	public List<HotelDTO> getHotelsByCostRange(@PathVariable (name="min") int min , @PathVariable (name="max") int max){
		
		return hotelServices.getHotelsByCostRange(min, max);
	}

}
