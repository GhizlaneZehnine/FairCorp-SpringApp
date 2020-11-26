package com.emse.spring.faircorp.DAO;

import com.emse.spring.faircorp.model.Room;

import java.util.List;

public interface RoomDAOCustom {
    List<Room> findRoomByName(String name);
}
