package com.vo2.example.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by VO2 on 04/04/2017.
 */
@Entity
@Table(name = "client")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="client_id")
    private Long id;

    @Column(name="client_name")
    private String name;

    ////////////////////////
    //  LES RELATIONS
    ////////////////////////
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="address_id", unique=true, nullable=false, updatable=false)
    private Address address;
    
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "clients")
    private List<Person> persons;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", name=" + name + '}';
    }
    
    
}
