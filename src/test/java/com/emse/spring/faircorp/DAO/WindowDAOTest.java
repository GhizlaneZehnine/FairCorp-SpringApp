package com.emse.spring.faircorp.DAO;

import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class WindowDAOTest {
    @Autowired
    private WindowDAO windowDAO;
    @Autowired
    private RoomDAO roomDAO;

    @Test
    public void shouldFindAWindow() {
        Window window = windowDAO.getOne(-10L);
        Assertions.assertThat(window.getName()).isEqualTo("Window 1");
        Assertions.assertThat(window.getWindowStatus()).isEqualTo(WindowStatus.CLOSED);
    }
    @Test
    public void shouldFindRoomOpenWindows() {
        List<Window> result = windowDAO.findRoomOpenWindows(-9L);
        Assertions.assertThat(result)
                .hasSize(1)
                .extracting("id", "windowStatus")
                .containsExactly(Tuple.tuple(-8L, WindowStatus.OPEN));
    }

    @Test
    public void shouldNotFindRoomOpenWindows() {
        List<Window> result = windowDAO.findRoomOpenWindows(-10L);
        Assertions.assertThat(result).isEmpty();
    }

    @Test
    public void shouldDeleteWindowsRoom() {
        Room room = roomDAO.getOne(-10L);
        List<Long> roomIds = room.getWindows().stream().map(Window::getId).collect(Collectors.toList());
        Assertions.assertThat(roomIds.size()).isEqualTo(2);

        windowDAO.deleteWindows(-10L);
        List<Window> result = windowDAO.findAllById(roomIds);
        Assertions.assertThat(result).isEmpty();

    }
}