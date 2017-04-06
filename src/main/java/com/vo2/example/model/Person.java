/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vo2.example.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author mehdi
 */
@Entity
@Table(name="person")
@Inheritance(strategy= InheritanceType.JOINED)
public class Person implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="person_id")
    private Long id;
    
    @Column(name="first_name")
    private String firstName;
    
    @Column(name="last_name")
    private String lastName;

    ////////////////////////
    //  LES RELATIONS
    ////////////////////////
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name="manager_id", nullable=true, updatable=true)
    private Manager manager;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "mission", joinColumns = {
                @JoinColumn(name = "person_id", nullable = false, updatable = false) },
		inverseJoinColumns = { @JoinColumn(name = "client_id",
			nullable = false, updatable = false) })
    private List<Client> clients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }
    
    
}
