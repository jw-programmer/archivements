package br.com.gamearchivement.gamearchivements.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.gamearchivement.gamearchivements.Enuns.ChallangeLevel;

@Entity
public class Archivement implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String Description;
    private Integer challangeLevel;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @JsonIgnore
    @OneToMany(mappedBy = "archivement")
    private List<PlayerGameArchivementDone> playerGameArchivementDones;

    public Archivement() {
        
    }

    public Archivement(Integer id, String description, ChallangeLevel challangeLevel) {
        this.id = id;
        Description = description;
        this.challangeLevel = (challangeLevel == null) ? null : challangeLevel.getLevel();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public ChallangeLevel getChallangeLevel() {
        return ChallangeLevel.toEnum(challangeLevel);
    }

    public void setChallangeLevel(ChallangeLevel challangeLevel) {
        this.challangeLevel = challangeLevel.getLevel();
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
        Archivement other = (Archivement) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    } 

}
