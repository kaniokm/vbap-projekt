package cz.foot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Player {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private long id;
    private String name;
    private String surname;
    private Date dateOfBirth;
    @ManyToOne()
    @JoinColumn(name = "tp_fk",insertable = false)
    @JsonBackReference
    private Team team;
    @Transient
    private String teamName;




    @Enumerated(EnumType.ORDINAL)
    private Position position;




    public Player() {
    }




    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public long getId() {        return id;    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public String getTeamName() {
        if (getTeam() == null)
            return "Free player";
        else
            return getTeam().getName();
    }
}
