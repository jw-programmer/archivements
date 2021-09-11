package br.com.gamearchivement.gamearchivements.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gamearchivement.gamearchivements.models.Game;
import br.com.gamearchivement.gamearchivements.repositories.GameRepository;
import br.com.gamearchivement.gamearchivements.services.Exceptions.ObjectNotFoundException;

@Service
public class GameService {

    @Autowired
    private GameRepository repo;

    public Game insert(Game obj){
        obj.setId(null);
        return repo.save(obj);
    }

    public Game find(Integer id) {
        Optional<Game> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Game don't exist!"));
    }

    public List<Game> findByName(String name) {
        return repo.findByNameLike(name);
    }

}
