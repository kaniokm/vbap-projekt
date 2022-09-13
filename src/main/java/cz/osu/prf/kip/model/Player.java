package cz.osu.prf.kip.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Player {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private long id;
    private String name;
    private String surname;
    private Date dateOfBirth;
    @ManyToOne()
    @JoinColumn(name = "tp_fk",insertable = false, updatable = false)
    private Team team;

    @Enumerated(EnumType.ORDINAL)
    private Position position;




    public Player() {
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


}
