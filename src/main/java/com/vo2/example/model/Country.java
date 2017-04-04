package com.vo2.example.model;

import javax.persistence.*;

/**
 * Created by VO2 on 04/04/2017.
 */
@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="country_id")
    private Long id;

    @Column(name = "country_name")
    private String name;

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

    @Override
    public String toString() {
        return "Country{" + "id=" + id + ", name=" + name + '}';
    }
    
}
