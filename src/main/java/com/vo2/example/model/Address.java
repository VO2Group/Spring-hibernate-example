package com.vo2.example.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by VO2 on 04/04/2017.
 */
@Entity
@Table(name = "address")
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="address_id")
    private Long id;

    @Column(name = "address_line_1")
    private String lineOne;

    @Column(name = "address_line_2")
    private String lineTwo;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "city")
    private String city;

    ////////////////////////
    //  LES RELATIONS
    ////////////////////////
    @ManyToOne(optional=false)
    @JoinColumn(name="country_id", nullable=false, updatable=false)
    private Country country;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLineOne() {
        return lineOne;
    }

    public void setLineOne(String lineOne) {
        this.lineOne = lineOne;
    }

    public String getLineTwo() {
        return lineTwo;
    }

    public void setLineTwo(String lineTwo) {
        this.lineTwo = lineTwo;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
