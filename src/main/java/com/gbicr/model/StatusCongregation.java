package com.gbicr.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "status_congregation")
public class StatusCongregation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  id;


    @Column
    private String name;

    @OneToMany(mappedBy = "statusCongregation")
    private List<Person> persons;


    public StatusCongregation() {
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

    public StatusCongregation(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


}
