package br.com.gamearchivement.gamearchivements.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gamearchivement.gamearchivements.models.PlayerGameArchivementDone;

@Repository
public interface PlayerGameArchivementDoneRepository extends JpaRepository<PlayerGameArchivementDone, Integer> {
    
}
