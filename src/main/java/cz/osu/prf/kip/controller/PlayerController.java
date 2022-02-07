package cz.osu.prf.kip.controller;


import cz.osu.prf.kip.model.Player;
import cz.osu.prf.kip.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PlayerController {
    @Autowired
    PlayerRepository playerRepository;
    PlayerController(PlayerRepository playerRepository){this.playerRepository = playerRepository;}


    @GetMapping("/players")
    List<Player> all()
    {

        return (List<Player>) playerRepository.findAll();
    }


    @PostMapping("/player")
    Player newPlayer(@RequestBody Player newPlayer)
    {
        return playerRepository.save(newPlayer);
    }
}
