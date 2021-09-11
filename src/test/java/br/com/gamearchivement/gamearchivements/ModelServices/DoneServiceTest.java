package br.com.gamearchivement.gamearchivements.ModelServices;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.gamearchivement.gamearchivements.enuns.ChallangeLevel;
import br.com.gamearchivement.gamearchivements.models.Archivement;
import br.com.gamearchivement.gamearchivements.models.Game;
import br.com.gamearchivement.gamearchivements.models.Player;
import br.com.gamearchivement.gamearchivements.models.PlayerGameArchivementDone;
import br.com.gamearchivement.gamearchivements.services.ArchivementService;
import br.com.gamearchivement.gamearchivements.services.GameService;
import br.com.gamearchivement.gamearchivements.services.PlayerGameArchivementDoneService;
import br.com.gamearchivement.gamearchivements.services.PlayerService;

@SpringBootTest
public class DoneServiceTest {
    @Autowired
    private PlayerGameArchivementDoneService service;

    private Player player;
    private Game game;
    private List<Archivement> archivement;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private GameService gameService;

    @Autowired
    private ArchivementService archivemeteService;

    @BeforeEach
    public void setUp(){
        player = playerService.insertPlayer(new Player(null, "x", "12345"));
        game = gameService.insert(new Game(null, "Mario"));
        archivement = archivemeteService.insertArchivments(Arrays.asList(new Archivement[] {new Archivement(null, "Jump", ChallangeLevel.EASY)}));
    }

    @Test
    void serviceCanMarkDone(){
        PlayerGameArchivementDone done = new PlayerGameArchivementDone(null, player, game, archivement.get(0));

        PlayerGameArchivementDone isDone = service.done(done);

        assertNotNull(isDone);

        assertTrue(service.isDone(isDone));
    }
}
