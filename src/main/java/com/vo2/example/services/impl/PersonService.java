/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vo2.example.services.impl;

import com.vo2.example.dao.IPersonDAO;
import com.vo2.example.model.Client;
import com.vo2.example.model.Manager;
import com.vo2.example.model.Person;
import com.vo2.example.services.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 *
 * @author mehdi
 */
@Service
@Transactional
public class PersonService implements IPersonService {
    
    @Autowired
    private IPersonDAO personDAO;
    
    @Override
    public Person getPersonById(Long id) {
        return personDAO.findPersonById(id);
    }

    @Override
    public Person saveOrUpdate(Person person) {
        return personDAO.save(person);
    }

    @Override
    public void detach(Person person) {
        personDAO.detach(person);
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
    
    @Override
    public List<Client> getPersonClients(Long id) {
        return personDAO.getPersonClients(id);
    }

    @Override
    public void updateWorkTime(Manager manager, int wt) {
        manager.setWorkTime(wt);
        manager.setFreeTime(100 - wt);
    }

}
