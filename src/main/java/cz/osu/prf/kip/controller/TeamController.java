package cz.osu.prf.kip.controller;



import cz.osu.prf.kip.model.Player;
import cz.osu.prf.kip.model.StaffMember;
import cz.osu.prf.kip.model.Team;
import cz.osu.prf.kip.repository.PlayerRepository;
import cz.osu.prf.kip.repository.StaffMemberRepository;
import cz.osu.prf.kip.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TeamController{
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private StaffMemberRepository staffMemberRepository;


    public TeamController(TeamRepository teamRepository, PlayerRepository playerRepository, StaffMemberRepository staffMemberRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
        this.staffMemberRepository = staffMemberRepository;
    }


    @GetMapping("/teams")
    List<Team> all()
    {

        return (List<Team>) teamRepository.findAll();
    }

    @GetMapping("/team/{teamId}")
    Team getById(@PathVariable Long teamId)
    {

        return teamRepository.findById(teamId)
                .orElseThrow(() -> new ResourceNotFoundException("Team not found with id: "+ teamId));
    }


    @PostMapping("/team")
    Team newTeam(@RequestBody Team newTeam)
    {
        return teamRepository.save(newTeam);
    }

    @PutMapping("/team/{teamId}/player/{playerId}")
    Team putPlayerInTeam(@PathVariable Long teamId,
                         @PathVariable Long playerId)
    {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new ResourceNotFoundException("Team not found with id: "+ teamId));
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found with id: "+ playerId));
        team.addPlayer(player);
        return teamRepository.save(team);
    }


    @PutMapping("/team/{teamId}/staffMember/{staffMemberId}")
    Team putStaffMemberInTeam(@PathVariable Long teamId,
                         @PathVariable Long staffMemberId)
    {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new ResourceNotFoundException("Team not found with id: "+ teamId));
        StaffMember staffMember = staffMemberRepository.findById(staffMemberId)
                .orElseThrow(() -> new ResourceNotFoundException("Staff member not found with id: "+ staffMemberId));
        team.addStaffMember(staffMember);
        return teamRepository.save(team);
    }

    @PutMapping("/team/{teamId}")
    Team updateTeamById(@PathVariable Long teamId, @RequestBody Team teamDetails)
    {
        Team team = teamRepository.findById(teamId).orElseThrow(()-> new ResourceNotFoundException("Team not found with id: "+ teamId));
        team.setName(teamDetails.getName());
        team.setLeagues(teamDetails.getLeagues());
        team.setPlayers(teamDetails.getPlayers());
        team.setStaffMembers(teamDetails.getStaffMembers());
        Team updatedTeam = teamRepository.save(team);

        return updatedTeam;

    }

}
