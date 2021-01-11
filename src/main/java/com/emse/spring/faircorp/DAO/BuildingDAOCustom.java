package com.emse.spring.faircorp.DAO;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Window;

import java.util.List;

public interface BuildingDAOCustom {
    List<Window> findWindowsByBuildingId(Long id);
    List<Heater> findHeatersByBuildingId(Long id);
}
