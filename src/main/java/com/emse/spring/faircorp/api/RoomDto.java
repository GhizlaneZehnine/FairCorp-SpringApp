package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.model.Room;


public class RoomDto {
    private Long id;
    private String name;
    private Double currentTemperature;


    public RoomDto() {
    }

    public RoomDto(Room room) {

        this.name = room.getName();
        this.id = room.getId();
        this.currentTemperature = room.getCurrentTemperature();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Double getCurrentTemperature() {
        return currentTemperature;
    }
    public void setCurrentTemperature(Double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }


    public void setName(String name) {
        this.name = name;
    }


}