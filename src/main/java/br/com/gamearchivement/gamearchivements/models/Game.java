package br.com.gamearchivement.gamearchivements.models;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Game implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    
    @OneToMany(mappedBy = "game", fetch = FetchType.EAGER)
    private List<Archivement> archivements = new LinkedList<>();

    @ManyToMany
    @JoinTable(name = "GAME_PLAYER", joinColumns = @JoinColumn(name="game_id"), inverseJoinColumns = @JoinColumn(name = "player_id"))
    private List<Player> players = new LinkedList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "game")
    private List<PlayerGameArchivementDone> playerGameArchivementDones;

    public Game() {
    }

    public Game(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Game(Integer id, String name, List<Archivement> archivements) {
        this.id = id;
        this.name = name;
        this.archivements = archivements;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Archivement> getArchivements() {
        return archivements;
    }

    public void setArchivements(List<Archivement> archivements) {
        this.archivements = archivements;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<PlayerGameArchivementDone> getPlayerGameArchivementDones() {
        return playerGameArchivementDones;
    }

    public void setPlayerGameArchivementDones(List<PlayerGameArchivementDone> playerGameArchivementDones) {
        this.playerGameArchivementDones = playerGameArchivementDones;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Game other = (Game) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}
