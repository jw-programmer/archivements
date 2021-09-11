package br.com.gamearchivement.gamearchivements.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gamearchivement.gamearchivements.models.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    List<Player> findByUsernameLike(String name);
}
