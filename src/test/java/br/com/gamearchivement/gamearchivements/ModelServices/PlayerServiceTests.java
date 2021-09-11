package br.com.gamearchivement.gamearchivements.ModelServices;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.gamearchivement.gamearchivements.models.Game;
import br.com.gamearchivement.gamearchivements.models.Player;
import br.com.gamearchivement.gamearchivements.repositories.GameRepository;
import br.com.gamearchivement.gamearchivements.repositories.PlayerRepository;
import br.com.gamearchivement.gamearchivements.services.PlayerService;

@SpringBootTest
public class PlayerServiceTests {
    @Autowired private PlayerService service;
    @Autowired private PlayerRepository prepo;
    @Autowired private GameRepository grepo;

    private Player player;
    private Game game;
    
    @BeforeEach
    public void setUp(){
        player = prepo.save(new Player(null, "x", "12345"));
        game = grepo.save(new Game(null, "mario"));
    }

    @Test
    void serviceCanAddGameToPlayer(){
        service.addGame(player.getId(), game);

        Player updatePlayer = service.find(player.getId());

        assertNotNull(updatePlayer.getGames());
        assertFalse(updatePlayer.getGames().isEmpty());
    }
    
}
