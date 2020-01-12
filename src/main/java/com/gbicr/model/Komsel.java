package com.gbicr.model;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "komsel")
public class Komsel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String region;

    @OneToMany(mappedBy = "komsel", cascade = CascadeType.ALL)
    private List<Person> persons;

    public Komsel(Integer id, String name, String region) {
        this.id = id;
        this.name = name;
        this.region = region;
    }

    public Komsel() {
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
