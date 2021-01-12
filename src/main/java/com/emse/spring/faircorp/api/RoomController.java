package com.emse.spring.faircorp.api;


import com.emse.spring.faircorp.DAO.RoomDAO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController // (1)
@RequestMapping("/api/rooms") // (2)
@Transactional // (3)
public class RoomController {
    RoomDAO roomDao;

    public RoomController(RoomDAO roomDao) {
        this.roomDao = roomDao;
    }

    @GetMapping // (5)
    public List<RoomDto> finAll(){
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public RoomDto finById(@PathVariable Long id){
        return roomDao.findById(id).map(RoomDto::new).orElse(null);
    }


}
