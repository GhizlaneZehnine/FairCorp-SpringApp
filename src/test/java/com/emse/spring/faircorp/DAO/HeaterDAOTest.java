package com.emse.spring.faircorp.DAO;

import com.emse.spring.faircorp.model.Heater;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.emse.spring.faircorp.model.Status;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class HeaterDAOTest {
    @Autowired
    private HeaterDAO heaterDAO;
    @Test
    public void shouldFindAHeater() {
        Heater heater = heaterDAO.getOne(-10L);
        Assertions.assertThat(heater.getName()).isEqualTo("Heater1");
        Assertions.assertThat(heater.getStatus()).isEqualTo(Status.ON);
    }
}