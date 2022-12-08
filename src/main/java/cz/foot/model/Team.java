package cz.foot.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity

public class Team {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "tp_fk",referencedColumnName = "id")

    private List<Player> players;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "ts_fk",referencedColumnName = "id")
    private List<StaffMember> staffMembers;

    @ManyToMany(mappedBy = "teams")
    @JsonIgnore
    private List<League> leagues;




    public Team() {
    }

    public Team(String name, List<Player> players, List<StaffMember> staffMembers, List<League> leagues) {
        this.name = name;
        this.players = players;
        this.staffMembers = staffMembers;
        this.leagues = leagues;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<StaffMember> getStaffMembers() {
        return staffMembers;
    }

    public void setStaffMembers(List<StaffMember> staffMembers) {
        this.staffMembers = staffMembers;
    }

    public List<League> getLeagues() {
        return leagues;
    }

    public void setLeagues(List<League> leagues) {
        this.leagues = leagues;
    }
    public void addPlayer(Player player)
    {
        players.add(player);
    }
    public void addStaffMember(StaffMember staffMember)
    {
        staffMembers.add(staffMember);
    }

}
