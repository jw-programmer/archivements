package br.com.gamearchivement.gamearchivements.ModelServices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.gamearchivement.gamearchivements.models.Game;
import br.com.gamearchivement.gamearchivements.services.GameService;
import br.com.gamearchivement.gamearchivements.services.Exceptions.ObjectNotFoundException;

@SpringBootTest
public class GameServiceTests {
    @Autowired
    GameService repo;

    private Game previo;


    @BeforeEach
    void setUp() {
        Game obj = new Game(null, "Super Mario");
        previo = repo.insert(obj);
    }

    @Test
    void serviceCanCreateGame() {
        Game game = new Game(null, "mario");
        Game isNew = repo.insert(game);

        assertNotNull(isNew.getId());
        assertTrue(isNew.getId() instanceof Integer);

        assertNotNull(isNew.getArchivements());
        assertTrue(isNew.getArchivements() instanceof List);
    }

    @Test
    void serviceCanFindAgameById() {
        Game search = repo.find(previo.getId());

        assertNotNull(search);
        assertTrue(search instanceof Game);
        assertEquals(previo, search);
    }

    @Test
    void serviceShootObejctNotFoundException() {
        assertThrows(ObjectNotFoundException.class, () -> {
            repo.find(9999);
        });
    }

}
