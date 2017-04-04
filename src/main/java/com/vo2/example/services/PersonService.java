/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vo2.example.services;

import com.vo2.example.dao.IPersonDAO;
import com.vo2.example.model.Manager;
import com.vo2.example.model.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author mehdi
 */
@Service
public class PersonService implements IPersonService {
    
    @Autowired
    private IPersonDAO personDAO;
    
    @Override
    public Person getPersonById(Long id) {
        return personDAO.findPersonById(id);
    }

    @Override
    public List<Person> findAll() {
        return personDAO.findAll();
    }

    @Override
    public List<Manager> findAllManager() {
        return personDAO.findAllManagers();
    }

    
    @Override
    public List<Person> getPersonsByName(String name) {
        return personDAO.searchPersonsByName(name);
    }

}
