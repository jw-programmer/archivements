package br.com.gamearchivement.gamearchivements.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gamearchivement.gamearchivements.enuns.Roles;
import br.com.gamearchivement.gamearchivements.models.Game;
import br.com.gamearchivement.gamearchivements.models.Player;
import br.com.gamearchivement.gamearchivements.repositories.GameRepository;
import br.com.gamearchivement.gamearchivements.repositories.PlayerRepository;
import br.com.gamearchivement.gamearchivements.services.Exceptions.ObjectNotFoundException;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repo;

    @Autowired
    private GameRepository grepo;

    public Player insertPlayer(Player player) {
        player.setId(null);
        player.addRoles(Roles.PLAYER);

        return repo.save(player);
    }

    public Player find(Integer id) {
        Optional<Player> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Game don't exist!"));
    }

    public List<Player> findByName(String name) {
        return repo.findByUsernameLike(name);
    }

    @Transactional
    public void addGame(Integer id, Game game) {
        Player player = find(id);
        player.getGames().add(game);
        repo.save(player);
        game.getPlayers().add(player);
        grepo.save(game);
    }
}
