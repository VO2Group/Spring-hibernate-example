/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vo2.example.dao;

import com.vo2.example.model.Person;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mehdi
 */
@Repository
public class PersonDAOImpl implements IPersonDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Person findPersonById(long id) {
        return (Person) sessionFactory.
                getCurrentSession().
                get(Person.class, id);
    }
}
