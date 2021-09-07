package br.com.gamearchivement.gamearchivements.models;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;

import br.com.gamearchivement.gamearchivements.enuns.Roles;

@Entity
@JsonTypeName("player")
public class Player extends SystemUser {
    private static final long serialVersionUID = 1L;

    @ManyToMany(mappedBy = "players")
    private List<Game> games = new LinkedList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "player")
    private List<PlayerGameArchivementDone> playerGameArchivementDones;

    public Player() {
        addRoles(Roles.PLAYER);
    }

    public Player(Integer id, String username, String password, List<Game> games) {
        super(id, username, password);
        this.games = games;
        addRoles(Roles.PLAYER);
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public List<PlayerGameArchivementDone> getPlayerGameArchivementDones() {
        return playerGameArchivementDones;
    }

    public void setPlayerGameArchivementDones(List<PlayerGameArchivementDone> playerGameArchivementDones) {
        this.playerGameArchivementDones = playerGameArchivementDones;
    }

}
