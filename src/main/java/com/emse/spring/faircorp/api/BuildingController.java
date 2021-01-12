package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.DAO.BuildingDAO;
import com.emse.spring.faircorp.model.Building;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/building")
@Transactional
public class BuildingController {

    private final BuildingDAO buildingDao;

    public BuildingController(BuildingDAO buildingDao) {

        this.buildingDao = buildingDao;
    }

    @GetMapping
    public List<BuildingDto> findAll() {
        return buildingDao.findAll().stream().map(BuildingDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{building_id}")
    public BuildingDto findById(@PathVariable Long building_id) {
        return buildingDao.findById(building_id).map(BuildingDto::new).orElse(null);
    }

    @DeleteMapping(path = "/{building_id}")
    public void delete(@PathVariable Long building_id) {
        buildingDao.deleteById(building_id);
    }

    @PostMapping // (8)
    public BuildingDto create(@RequestBody BuildingDto dto) {
        Building building = null;
        if (dto.getId() == null) {
            building = buildingDao.save(new Building(dto.getId(), dto.getName()));
        } else {
            building = buildingDao.getOne(dto.getId());
            building.setName(dto.getName());
        }
        return new BuildingDto(building);
    }
}