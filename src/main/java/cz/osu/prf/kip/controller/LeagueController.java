package cz.osu.prf.kip.controller;


import cz.osu.prf.kip.model.League;
import cz.osu.prf.kip.model.Team;
import cz.osu.prf.kip.repository.LeagueRepository;

import cz.osu.prf.kip.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class LeagueController {
    @Autowired
    LeagueRepository leagueRepository;
    TeamRepository teamRepository;

    public LeagueController(LeagueRepository leagueRepository, TeamRepository teamRepository) {
        this.leagueRepository = leagueRepository;
        this.teamRepository = teamRepository;
    }


    @GetMapping("/leagues")
    List<League> all()
    {

        return (List<League>) leagueRepository.findAll();
    }

    @GetMapping("/league/{id}")
    League getbyId(@PathVariable Long leagueId)
    {

        return leagueRepository.findById(leagueId).orElseThrow(() -> new ResourceNotFoundException("League not found with id: "+ leagueId));
    }


    @PostMapping("/league")
    League newLeague(@RequestBody League newLeague)
    {
        return leagueRepository.save(newLeague);
    }

    @PutMapping("/league/{leagueId}/team/{teamId}")
    League putTeamInLeague(@PathVariable Long leagueId,
                              @PathVariable Long teamId)
    {


        League league = leagueRepository.findById(leagueId)
                .orElseThrow(() -> new ResourceNotFoundException("League not found with id: "+ leagueId));
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new ResourceNotFoundException("Team not found with id: "+ teamId));

        league.addTeam(team);


        return leagueRepository.save(league);
    }


}
