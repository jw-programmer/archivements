package br.com.gamearchivement.gamearchivements.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gamearchivement.gamearchivements.models.PlayerGameArchivementDone;
import br.com.gamearchivement.gamearchivements.repositories.PlayerGameArchivementDoneRepository;

@Service
public class PlayerGameArchivementDoneService {

    @Autowired
    private PlayerGameArchivementDoneRepository repo;

    public PlayerGameArchivementDone done(PlayerGameArchivementDone done){
        return repo.save(done);
    }

    public Boolean isDone(PlayerGameArchivementDone done){
        Integer have = repo.CountByGameAndArchivementAndPlayer(done.getGame(), done.getArchivement(), done.getPlayer());
        return have >= 1;
    }
}