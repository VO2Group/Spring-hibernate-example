/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vo2.example.services;

import com.vo2.example.model.Manager;
import com.vo2.example.model.Person;
import org.junit.After;
import org.junit.Before;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author mehdi
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:config/Context.xml")
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
    @Test
    public void testGetPersonById() {
        System.out.println("getPersonById");
        Long id = 1L;
        Person result = personService.getPersonById(id);
        assertEquals("Mehdi", result.getFirstName());

    }

    @Test
    public void getPersonByIdShouldResolveInheritance() {
        Person personManager = personService.getPersonById(3L);
        assertThat(personManager, is(instanceOf(Manager.class)));
        Manager manager = (Manager) personManager;
        assertThat(manager.getFreeTime(), is(50));
        assertThat(manager.getWorkTime(), is(50));
        assertThat(manager.getFirstName(), is(equalTo("Julien")));
        assertThat(manager.getLastName(), is(equalTo("Rouziere")));
    }

    @Test
    public void findAllShouldReturnAllPersons() {
        List<Person> allPersons = personService.findAll();
        assertThat(allPersons, is(not(nullValue())));
        assertThat(allPersons.size(), equalTo(3));

        List<Manager> managers = allPersons.stream()
                .filter(person -> person instanceof Manager)
                .map(person -> (Manager) person)
                .collect(Collectors.toList());

        assertThat(managers.size(), equalTo(1));
        assertThat(managers.get(0).getId(), equalTo(3L));
        assertThat(managers.get(0).getFirstName(), equalTo("Julien"));

        List<Person> others = allPersons.stream()
                .filter(person -> !(person instanceof Manager))
                .collect(Collectors.toList());
        assertThat(others.size(), equalTo(2));

    }

    @Test
    public void findAllManagersShouldReturnOnlyManagers() {
        List<Manager> allManagers = personService.findAllManager();
        assertThat(allManagers, is(not(nullValue())));
        assertThat(allManagers.size(), equalTo(1));
        Manager manager = allManagers.get(0);
        assertThat(manager.getId(), equalTo(3L));
        assertThat(manager.getFirstName(), equalTo("Julien"));
    }

}
