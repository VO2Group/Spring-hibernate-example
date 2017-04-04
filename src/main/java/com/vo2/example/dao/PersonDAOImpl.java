/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vo2.example.dao;

import com.vo2.example.model.Manager;
import com.vo2.example.model.Person;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public Person findPersonById(Long id) {
        return em.find(Person.class, id);
    }

    @Override
    public List<Person> findAll() {
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
        return query.getResultList();
    }

    @Override
    public List<Manager> findAllManagers() {
        TypedQuery<Manager> query = em.createQuery("SELECT m FROM Manager m", Manager.class);
        return query.getResultList();
    }
    
    @Override
    public List<Person> searchPersonsByName(String name) {
        Query query = em.createQuery("FROM Person WHERE firstName LIKE :name OR lastName LIKE :name");
        query.setParameter("name", name);
        return query.getResultList();
    }
    
}
