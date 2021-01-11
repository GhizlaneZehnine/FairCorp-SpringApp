package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Status;

public class HeaterDto {
    private Long id;
    private String name;
    private Long power;
    private Long roomId;
    private Status heaterStatus;

    public HeaterDto() {
    }

    public HeaterDto(Heater heater){
        this.id = heater.getId();
        this.name = heater.getName();
        this.power = heater.getPower();
        this.heaterStatus = heater.getStatus();
        this.roomId = heater.getRoom().getId();
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

    public void setName(String name) {
        this.name = name;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Status getHeaterStatus() {
        return heaterStatus;
    }

    public void setHeaterStatus(Status heaterStatus) {
        this.heaterStatus = heaterStatus;
    }
}
