package cz.osu.prf.kip.model;

import javax.persistence.*;

@Entity
public class Player {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private long id;
    private String name;
    private String surname;


    public Player() {
    }

    public Player(String name, String surname) {
        this.name = name;
        this.surname = surname;

    }

    public long getId() {
        return id;
    }

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
}
