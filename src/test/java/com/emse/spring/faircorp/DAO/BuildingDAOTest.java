package com.emse.spring.faircorp.DAO;

import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Window;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BuildingDAOTest {
    @Autowired
    private BuildingDAO buildingDAO;

    @Test
    public void shouldFindABuilding() {
        Building building = buildingDAO.getOne(-10L);
        Assertions.assertThat(building.getName()).isEqualTo("Building1");
    }

    @Test
    public void shouldFindBuildingWindows(){
        List<Window> result = buildingDAO.findWindowsByBuildingId(-10L);
        Assertions.assertThat(result).hasSize(2);
    }

    @Test
    public void shouldFindBuildingHeaters(){
        List<Heater> result = buildingDAO.findHeatersByBuildingId(-10L);
        Assertions.assertThat(result).hasSize(2);
    }
}
