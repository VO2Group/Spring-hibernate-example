package com.vo2.example.model;

import javax.persistence.*;
import java.io.Serializable;

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
    @OneToOne(optional = false)
    @JoinColumn(name="address_id", unique=true, nullable=false, updatable=false)
    private Address address;

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
}
