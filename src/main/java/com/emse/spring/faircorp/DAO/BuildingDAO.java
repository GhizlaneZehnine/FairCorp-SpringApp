package com.emse.spring.faircorp.DAO;

import com.emse.spring.faircorp.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingDAO extends JpaRepository<Building, Long> , BuildingDAOCustom {
}
