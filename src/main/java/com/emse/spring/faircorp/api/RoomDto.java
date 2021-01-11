package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.model.Room;


public class RoomDto {
    private Long id;
    private String name;
    private Double currentTemperature;
    private Long buildingId;


    public RoomDto() {
    }

    public RoomDto(Room room) {

        this.name = room.getName();
        this.id = room.getId();
        this.currentTemperature = room.getCurrentTemperature();
        this.buildingId = room.getBuilding().getId();
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
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