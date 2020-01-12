package com.gbicr.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "status_person")
@Table(name = "status_person")
public class StatusPerson implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @OneToMany(mappedBy = "statusPerson", cascade = CascadeType.ALL)
    private List<Person> person;

    public StatusPerson(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public StatusPerson() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
