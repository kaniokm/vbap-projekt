package cz.foot.service;

import cz.foot.model.League;
import cz.foot.model.Team;
import cz.foot.repository.LeagueRepository;
import cz.foot.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class LeagueService {

    private final LeagueRepository leagueRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public LeagueService(LeagueRepository leagueRepository, TeamRepository teamRepository) {
        this.leagueRepository = leagueRepository;
        this.teamRepository = teamRepository;
    }

    public Iterable<League> getAllLeagues()
    {

        return leagueRepository.findAll();
    }

    public League getLeagueById(Long leagueId)
    {

        return leagueRepository.findById(leagueId).orElseThrow(() -> new ResourceNotFoundException("League not found with id: "+ leagueId));
    }

    public League newLeague(League newLeague)
    {
        return leagueRepository.save(newLeague);
    }

    public League updateLeague(Long id, League leagueDetails)
    {
        League league = leagueRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("League not found with id: "+ id));
        league.setName(leagueDetails.getName());

        return leagueRepository.save(league);
    }

    public League putTeamInLeague(Long leagueId, Long teamId)
    {
        League league = leagueRepository.findById(leagueId)
                .orElseThrow(() -> new ResourceNotFoundException("League not found with id: "+ leagueId));
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new ResourceNotFoundException("Team not found with id: "+ teamId));
        league.addTeam(team);
        return leagueRepository.save(league);
    }

    public void deleteLeagueById(Long leagueId)
    {
        League league = leagueRepository.findById(leagueId).orElseThrow(() -> new ResourceNotFoundException("League not found with id: "+ leagueId));
        leagueRepository.delete(league);
    }





}
