package cz.foot.service;

import cz.foot.model.Player;
import cz.foot.model.StaffMember;
import cz.foot.model.Team;
import cz.foot.repository.PlayerRepository;
import cz.foot.repository.StaffMemberRepository;
import cz.foot.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;

    private final StaffMemberRepository staffMemberRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository, PlayerRepository playerRepository, StaffMemberRepository staffMemberRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
        this.staffMemberRepository = staffMemberRepository;
    }

    public Iterable<Team> getAllTeams()
    {
        return teamRepository.findAll();
    }

    public Team getTeamById(Long teamId)
    {

        return teamRepository.findById(teamId)
                .orElseThrow(() -> new ResourceNotFoundException("Team not found with id: "+ teamId));
    }

    public Team createTeam(Team newTeam)
    {
        return teamRepository.save(newTeam);
    }

    public Team transferPlayer(Long teamId, Long playerId)
    {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new ResourceNotFoundException("Team not found with id: "+ teamId));
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found with id: "+ playerId));
        team.addPlayer(player);

        return teamRepository.save(team);
    }

    @PutMapping("/team/{teamId}/staffMember/{staffMemberId}")
    public Team putStaffMemberInTeam(@PathVariable Long teamId,
                              @PathVariable Long staffMemberId)
    {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new ResourceNotFoundException("Team not found with id: "+ teamId));
        StaffMember staffMember = staffMemberRepository.findById(staffMemberId)
                .orElseThrow(() -> new ResourceNotFoundException("Staff member not found with id: "+ staffMemberId));
        team.addStaffMember(staffMember);
        return teamRepository.save(team);
    }

    public Team updateTeamById(@PathVariable Long teamId, @RequestBody Team teamDetails)
    {
        Team team = teamRepository.findById(teamId).orElseThrow(()-> new ResourceNotFoundException("Team not found with id: "+ teamId));
        team.setName(teamDetails.getName());
        team.setLeagues(teamDetails.getLeagues());
        team.setPlayers(teamDetails.getPlayers());
        team.setStaffMembers(teamDetails.getStaffMembers());

        return teamRepository.save(team);

    }

    public void deleteTeam(@PathVariable Long teamId)
    {
        Team team = teamRepository.findById(teamId).orElseThrow(()-> new ResourceNotFoundException("Team not found with id: "+ teamId));
        teamRepository.delete(team);

    }



}
