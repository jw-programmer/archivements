package br.com.gamearchivement.gamearchivements.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gamearchivement.gamearchivements.models.Player;
import br.com.gamearchivement.gamearchivements.services.PlayerService;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping(value = "/player")
public class playerResource {
    @Autowired
    private PlayerService service;

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Player>> getAll() {
        List<Player> players = service.findAll();

        return ResponseEntity.ok().body(players);
    }
    
}
