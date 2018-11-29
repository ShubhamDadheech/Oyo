package com.oyo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oyo.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {


}
