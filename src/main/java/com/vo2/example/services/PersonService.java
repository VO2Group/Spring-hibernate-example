/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vo2.example.services;

import com.vo2.example.dao.IPersonDAO;
import com.vo2.example.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mehdi
 */
@Service
public class PersonService implements IPersonService {
    
    @Autowired
    private IPersonDAO personDAO;
    
    @Override
    public Person getPersonById(long id) {
        return personDAO.findPersonById(id);
    }
    
}
