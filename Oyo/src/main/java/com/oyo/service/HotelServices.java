package com.oyo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oyo.dto.HotelDTO;
import com.oyo.dto.RoomDTO;
import com.oyo.entity.Address;
import com.oyo.entity.Facility;
import com.oyo.entity.Hotel;
import com.oyo.entity.Room;
import com.oyo.repository.HotelRepository;

@Service
public class HotelServices {

	@Autowired
	private HotelRepository hotelrepository;

	/**
	 * @return list of HotelDTOs
	 */
	public List<HotelDTO> getAllHotelList() {
		List<Hotel> hotels = hotelrepository.findAll();
		List<HotelDTO> hotelDTOs = hotels.stream().map(dto -> new HotelDTO(dto, true)).collect(Collectors.toList());
		return hotelDTOs;
	}

	/**
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public HotelDTO getHotelById(int id) throws Exception {

		Hotel hotel = hotelrepository.findById(id).get();
		if (hotel == null) {
			throw new Exception("Hotel not found");
		}
		HotelDTO hotelDTO = new HotelDTO(hotel);
		return hotelDTO;
	}

	/**
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Hotel findHotelById(int id) throws Exception {
		Hotel hotel = hotelrepository.findById(id).get();
		if (hotel == null) {
			throw new Exception("Hotel not found");
		}
		return hotel;

	}

	/**
	 * @param hotelDTO
	 * @return
	 * @throws Exception
	 */
	public HotelDTO createUpdateHotel(HotelDTO hotelDTO) throws Exception {
		Hotel hotelnew = new Hotel(hotelDTO);
		if (hotelnew.getId() != 0) {
			if (findHotelById(hotelnew.getId()) == null) {
				throw new Exception("Hotel not found");
			} else {
				hotelnew = findHotelById(hotelDTO.getId());
				validateHotel(hotelnew, hotelDTO);
				hotelrepository.save(hotelnew);
				return getHotelById(hotelnew.getId());
			}
		}

		hotelrepository.save(hotelnew);
		return getHotelById(hotelnew.getId());
	}

	/**
	 * @param hotel
	 * @param hotelDTO
	 * @return Hotel
	 * @throws Exception
	 */
	public Hotel validateHotel(Hotel hotel, HotelDTO hotelDTO) throws Exception {
		if (hotelDTO.getHotelName() != null) {
			hotel.setHotelName(hotelDTO.getHotelName());
		} else {
			throw new Exception("Hotel name must not null");
		}
		if (hotelDTO.getAddress() != null) {
			hotel.setAddress(new Address(hotelDTO.getAddress()));
		} else {
			throw new Exception("Hotel address must not null");
		}
		if (hotelDTO.getFacility() != null) {
			hotel.setFacility(new Facility(hotelDTO.getFacility()));
		} else {
			throw new Exception("Hotel facility must not null");
		}
		if (hotelDTO.getRooms() != null) {
			hotel.setRooms(
					new ArrayList<>(hotelDTO.getRooms().stream().map(dt -> new Room(dt)).collect(Collectors.toList())));

		}
		return hotel;
	}

	/**
	 * delete all user
	 */

	public void deleteAllHotel() {
		hotelrepository.deleteAll();
	}

	/**
	 * delete hotel by id
	 * 
	 * @param id
	 * @throws Exception
	 */

	public void deletehotelById(int id) throws Exception {
		Hotel hotel = findHotelById(id);
		if (hotel == null) {
			throw new Exception("hotel not found");
		}
		hotelrepository.delete(hotel);

	}

	/**
	 * get list of hotel by city
	 * 
	 * @param city
	 * @return
	 */
	public List<HotelDTO> getHotelByCity(String city) {
		List<Hotel> hotels = hotelrepository.findAll();
		hotels = hotels.stream().filter(t -> (t.getAddress().getCity().equals(city))).collect(Collectors.toList());

		return hotels.stream().map(HotelDTO::new).collect(Collectors.toList());
	}

	/**
	 * get list of hotels by min price and max price
	 * 
	 * @param minRange
	 * @param maxRange
	 * @return
	 */
	public List<HotelDTO> getHotelsByCostRange(int minRange, int maxRange) {

		List<Hotel> hotels = hotelrepository.findAll();
	
		List<HotelDTO> filteredList = new ArrayList<>();

		hotels.stream().forEach(dt -> {
			if (dt.getRooms() != null && !dt.getRooms().isEmpty()) {
				List<RoomDTO> roomDTOs= dt.getRooms().stream().filter(room -> room.getRoomCost() >= minRange && room.getRoomCost() <= maxRange)
						.map(RoomDTO::new).collect(Collectors.toList());
				if(!roomDTOs.isEmpty()) {
					HotelDTO hotelDTO=new HotelDTO(dt);
					hotelDTO.setRooms(roomDTOs);
					filteredList.add(hotelDTO);
				}
			}

		});
		
		
		return filteredList;
	}

}
