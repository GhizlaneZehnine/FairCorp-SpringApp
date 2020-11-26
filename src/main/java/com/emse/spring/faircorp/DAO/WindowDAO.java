package com.emse.spring.faircorp.DAO;

import com.emse.spring.faircorp.model.Window;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface WindowDAO extends JpaRepository<Window,Long>, WindowDAOCustom {

    @Modifying
    @Query("delete from Window w where w.room.id =:roomId")
    void deleteWindows(@Param("roomId") Long id);

}
