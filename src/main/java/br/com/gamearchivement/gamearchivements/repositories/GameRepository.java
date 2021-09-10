package br.com.gamearchivement.gamearchivements.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gamearchivement.gamearchivements.models.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

    List<Game> findByNameLike(String name);

}
