package cz.foot.controller;

import cz.foot.model.Player;
import cz.foot.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PlayerController {


    @Autowired
    private final PlayerService playerService;
    PlayerController(PlayerService playerService){

        this.playerService = playerService;
    }

    @GetMapping("/players")
    Iterable<Player> all()
    {
        return playerService.getAllPlayers();
    }

    @PostMapping("/player")
    Optional<Player> newPlayer(@RequestBody Player newPlayer)
    {
        return playerService.newPlayer(newPlayer);
    }

    @GetMapping("/player/{id}")
    Player getPlayerById(@PathVariable Long id)
    {
        return playerService.getPlayerById(id);
    }

    @PutMapping("/player/{id}")
    public Player updatePlayer(@PathVariable Long id, @RequestBody Player playerDetails)
    {
        return playerService.updatePlayer(id,playerDetails);
    }

    @DeleteMapping("/player/{id}")
    void deletePlayer(@PathVariable Long id)
    {
       playerService.deletePlayer(id);
    }

}
