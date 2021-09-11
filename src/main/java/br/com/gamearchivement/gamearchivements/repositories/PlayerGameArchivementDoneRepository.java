package br.com.gamearchivement.gamearchivements.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.gamearchivement.gamearchivements.models.Archivement;
import br.com.gamearchivement.gamearchivements.models.Game;
import br.com.gamearchivement.gamearchivements.models.Player;
import br.com.gamearchivement.gamearchivements.models.PlayerGameArchivementDone;

@Repository
public interface PlayerGameArchivementDoneRepository extends JpaRepository<PlayerGameArchivementDone, Integer> {

    @Query("select count(*) from PlayerGameArchivementDone done where done.game = ?1 and done.archivement = ?2 and done.player = ?3")
    public Integer CountByGameAndArchivementAndPlayer(Game game, Archivement archivement, Player player);
}
