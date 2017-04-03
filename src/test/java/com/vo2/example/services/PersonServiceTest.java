/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vo2.example.services;

import com.vo2.example.model.Person;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author mehdi
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:config/context.xml")
public class PersonServiceTest {
    
    @Autowired
    private PersonService personService;
    
    public PersonServiceTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPersonById method, of class PersonService.
     */
    @org.junit.Test
    public void testGetPersonById() {
        System.out.println("getPersonById");
        long id = 1;
        Person result = personService.getPersonById(id);
        assertEquals("Mehdi", result.getFistName());

    }
    
}
