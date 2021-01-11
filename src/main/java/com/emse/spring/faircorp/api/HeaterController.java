package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.DAO.HeaterDAO;
import com.emse.spring.faircorp.DAO.RoomDAO;
import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/heaters")
@Transactional
public class HeaterController {

    private final HeaterDAO heaterDao;
    private final RoomDAO roomDao;

    public HeaterController(HeaterDAO heaterDao, RoomDAO roomDao) { // DAOs used by this controller are injected via constructor
        this.heaterDao = heaterDao;
        this.roomDao = roomDao;
    }

    @GetMapping
    public List<HeaterDto> findAll() {
        return heaterDao.findAll().stream().map(HeaterDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{heater_id}")
    public HeaterDto findById(@PathVariable Long heater_id) {
        return heaterDao.findById(heater_id).map(HeaterDto::new).orElse(null);
    }

    @DeleteMapping(path = "/{heater_id}")
    public void delete(@PathVariable Long heater_id) {
        heaterDao.deleteById(heater_id);
    }

    @PostMapping // (8)
    public HeaterDto create(@RequestBody HeaterDto dto) {
        Room room = roomDao.getOne(dto.getRoomId());
        Heater heater = null;
        if (dto.getId() == null) {
            heater = heaterDao.save(new Heater(dto.getPower(), dto.getName(), room, dto.getHeaterStatus()));
        } else {
            heater = heaterDao.getOne(dto.getId());
            heater.setStatus(dto.getHeaterStatus());
        }
        return new HeaterDto(heater);
    }
}
