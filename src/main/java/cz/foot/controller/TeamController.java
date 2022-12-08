package cz.foot.controller;



import cz.foot.repository.PlayerRepository;
import cz.foot.repository.StaffMemberRepository;
import cz.foot.repository.TeamRepository;
import cz.foot.model.Player;
import cz.foot.model.StaffMember;
import cz.foot.model.Team;
import cz.foot.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TeamController{

    TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/teams")
    Iterable<Team> all()
    {
        return teamService.getAllTeams();
    }

    @GetMapping("/team/{teamId}")
    Team getById(@PathVariable Long teamId)
    {

        return teamService.getTeamById(teamId);
    }


    @PostMapping("/team")
    Team createTeam(@RequestBody Team newTeam)
    {
        return teamService.createTeam(newTeam);
    }

    @PutMapping("/team/{teamId}/player/{playerId}")
    Team transferPlayer(@PathVariable Long teamId, @PathVariable Long playerId)
    {
        return teamService.transferPlayer(teamId,playerId);
    }




    @PutMapping("/team/{teamId}/staffMember/{staffMemberId}")
    Team putStaffMemberInTeam(@PathVariable Long teamId,
                         @PathVariable Long staffMemberId)
    {
        return teamService.putStaffMemberInTeam(teamId,staffMemberId);
    }

    @PutMapping("/team/{teamId}")
    Team updateTeamById(@PathVariable Long teamId, @RequestBody Team teamDetails)
    {
        return teamService.updateTeamById(teamId,teamDetails);
    }

    @DeleteMapping("/team/{teamId}")
    void deleteTeam(@PathVariable Long teamId)
    {
        teamService.deleteTeam(teamId);
    }

}
