/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vo2.example.dao;

import com.vo2.example.model.Person;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mehdi
 */
@Repository
public class PersonDAOImpl implements IPersonDAO {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Person findPersonById(long id) {       
        return (Person) em.find(Person.class, id);
    }
}
