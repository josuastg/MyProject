package com.gbicr.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service")
public class Worship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column
    private String name;

//    @ManyToMany(mappedBy = "service")
//    private List<Person> persons;


    public Worship(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Worship() {
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
