package br.com.gamearchivement.gamearchivements.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PlayerGameArchivementDone implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "archivement_id")
    private Archivement archivement;

    public PlayerGameArchivementDone() {
    }

    public PlayerGameArchivementDone(Integer id, Player player, Game game, Archivement archivement) {
        this.id = id;
        this.player = player;
        this.game = game;
        this.archivement = archivement;
    }

    public PlayerGameArchivementDone(Player player, Game game, Archivement archivement) {
        this.player = player;
        this.game = game;
        this.archivement = archivement;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Archivement getArchivement() {
        return archivement;
    }

    public void setArchivement(Archivement archivement) {
        this.archivement = archivement;
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
        PlayerGameArchivementDone other = (PlayerGameArchivementDone) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
