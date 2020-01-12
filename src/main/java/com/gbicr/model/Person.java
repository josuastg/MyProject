package com.gbicr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "person")
@Table(name = "person")

public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;


    @Column
    private String address;

    @Column
    private String phone_number;

    @Column
    private String email;

    @Column
    private Date birthdate;

    @ManyToOne
    @JoinColumn(name = "gender_id", nullable = true)
    private Gender gender;

    @ManyToOne
    @JoinColumn (name="komsel_id", nullable = true)
    private Komsel komsel;

    @ManyToOne
    @JoinColumn(name="status_person_id", nullable = true)
    private StatusPerson statusPerson;


    @ManyToOne
    @JoinColumn(name = "status_congregation_id", nullable = true)
    private StatusCongregation statusCongregation;

    @ManyToMany(mappedBy  = "person")
    private List <Worship> worships;

    public List<Worship> getWorships() {
        return worships;
    }

    public void setWorships(List<Worship> worships) {
        this.worships = worships;
    }

    @ManyToOne
    @JoinColumn(name = "family_id", nullable = true)
    private Family family;

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    //    @ManyToMany( cascade = {CascadeType.ALL})
//    @JoinTable(name = "person_has_family", joinColumns = {@JoinColumn(name = "person_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "family_id", referencedColumnName = "id")})
//    private Set<Person> persons  = new HashSet<Person>();
//
//
//    @ManyToMany(mappedBy = "persons")
//    @JsonIgnore
//    private Set<Person> family = new HashSet<Person>();



    public Person(Integer id, String name,  String address, String phone_number, String email, Date birthdate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
        this.email = email;
        this.birthdate = birthdate;
    }

    public Person() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public StatusCongregation getStatusCongregation() {
        return statusCongregation;
    }

    public void setStatusCongregation(StatusCongregation statusCongregation) {
        this.statusCongregation = statusCongregation;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Komsel getKomsel() {
        return komsel;
    }
    public StatusPerson getStatusPerson() {
        return statusPerson;
    }

    public void setStatusPerson(StatusPerson statusPerson) {
        this.statusPerson = statusPerson;
    }


    public void setKomsel(Komsel komsel) {
        this.komsel = komsel;
    }

}
