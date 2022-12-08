package cz.foot.controller;


import cz.foot.model.League;

import cz.foot.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class LeagueController {

    @Autowired
    private final LeagueService leagueService;

    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @GetMapping("/leagues")
    Iterable<League> getAllLeagues()
    {
        return leagueService.getAllLeagues();
    }

    @GetMapping("/league/{id}")
    League getById(@PathVariable Long id)
    {
        return leagueService.getLeagueById(id);
    }


    @PostMapping("/league")
    League newLeague(@RequestBody League newLeague)
    {
        return leagueService.newLeague(newLeague);
    }

    @PutMapping("/league/{id}")
    League updateLeague(@PathVariable Long id, @RequestBody League leagueDetails)
    {
        return leagueService.updateLeague(id,leagueDetails);
    }

    @PutMapping("/league/{leagueId}/team/{teamId}")
    League putTeamInLeague(@PathVariable Long leagueId, @PathVariable Long teamId)
    {
        return leagueService.putTeamInLeague(leagueId,teamId);
    }

    @DeleteMapping("/league/{leagueId}")
    void deleteById(@PathVariable Long leagueId)
    {
        leagueService.deleteLeagueById(leagueId);
    }


}
