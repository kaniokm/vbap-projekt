package cz.foot.service;

import cz.foot.model.Player;
import cz.foot.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    public Iterable<Player> getAllPlayers()
    {
        return playerRepository.findAll();
    }
    public Optional<Player> newPlayer(Player newPlayer)
    {
        if (newPlayer.getName()!=null && newPlayer.getSurname()!=null ) {

            return Optional.of(playerRepository.save(newPlayer));
        }
        return Optional.empty();

    }

    public Player getPlayerById(Long id)
    {

        return playerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player does not exists with id: "+id));
    }

    public Player updatePlayer(Long id, Player playerDetails)
    {
        Player player = playerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player does not exists with id: "+id));

        player.setName(playerDetails.getName());
        player.setSurname(playerDetails.getSurname());
        player.setDateOfBirth(playerDetails.getDateOfBirth());
        player.setPosition(playerDetails.getPosition());

        return playerRepository.save(player);
    }

    public void deletePlayer(Long id){

        Player player = playerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player does not exists with id: "+id));

        playerRepository.delete(player);



    }



}
