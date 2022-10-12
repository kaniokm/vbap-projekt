package cz.osu.prf.kip.controller;


import cz.osu.prf.kip.model.Player;
import cz.osu.prf.kip.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;
    PlayerController(PlayerRepository playerRepository){this.playerRepository = playerRepository;}


   @GetMapping("/playerTeam/{id}")
    String getPlayerTeamName(@PathVariable Long id)
    {
        Player player = playerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player not exists with id: "+id));
        if (player.getTeam() == null)
        return "Free player";
        else
        return player.getTeam().getName();
    }



    @GetMapping("/players")
    Iterable<Player> all()
    {

        return playerRepository.findAll();
    }

    @GetMapping("/playerDate/{id}")
    Date getLocalDateById(@PathVariable Long id)
    {
        Player player = playerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player not exists with id: "+id));


        return player.getDateOfBirth();
    }


    @PostMapping("/player")
    Player newPlayer(@RequestBody Player newPlayer)
    {
        return playerRepository.save(newPlayer);
    }

    @GetMapping("/player/{id}")
    Player getPlayerById(@PathVariable Long id)
    {
        return playerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player not exists with id: "+id));
    }




    @PutMapping("/player/{id}")
    public Player updatePlayer(@PathVariable Long id, @RequestBody Player playerDetails)
    {
        Player player = playerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player not exists with id: "+id));

        player.setName(playerDetails.getName());
        player.setSurname(playerDetails.getSurname());
        player.setDateOfBirth(playerDetails.getDateOfBirth());
        player.setPosition(playerDetails.getPosition());


        Player updatedPlayer = playerRepository.save(player);

        return updatedPlayer;
    }

    @DeleteMapping("/player/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePlayer(@PathVariable Long id){

        Player player = playerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player not exists with id: "+id));

        playerRepository.delete(player);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);

    }

}
