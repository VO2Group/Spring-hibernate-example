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
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author mehdi
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:config/Context.xml")
@Transactional
public class PersonServiceTest {
    
    @Autowired
    private IPersonService personService;

    @Autowired
    private IClientService clientService;
    
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
    public void testGetPersonByIdShouldReturnPerson() {
        //GIVEN : an exitent id of person in DB
        Long id = 1L;

        //WHEN : fetch person by id
        Person result = personService.getPersonById(id);

        //THEN : service returns the good person
        assertThat(result, is(notNullValue()));
        assertEquals("Mehdi", result.getFirstName());
        System.out.println("\n\n++++++++++++++++  getPersonById returned " + result);

    }

    @Test
    public void getPersonByIdShouldResolveInheritance() {
        //GIVEN : an exitent id of manager in DB
        Long id = 1L;

        //WHEN : fetch person by its id
        Person personManager = personService.getPersonById(3L);

        //THEN : a person entity is returned and it's a Manager instance
        assertThat(personManager, is(notNullValue()));
        assertThat(personManager, is(instanceOf(Manager.class)));
        Manager manager = (Manager) personManager;
        assertThat(manager.getFreeTime(), is(50));
        assertThat(manager.getWorkTime(), is(50));
        assertThat(manager.getFirstName(), is(equalTo("Julien")));
        assertThat(manager.getLastName(), is(equalTo("Rouzieres")));
        System.out.println("\n\n++++++++++++++++ getPersonById returned " + personManager);
    }

    @Test
    public void findAllShouldReturnAllPersons() {
        //WHEN : call service method
        List<Person> allPersons = personService.findAll();

        //THEN : return all persons (containing managers!)
        assertThat(allPersons, is(notNullValue()));
        assertThat(allPersons.size(), equalTo(3));

        System.out.println("\n\n++++++++++++++++ findAll =>  " + allPersons);

        //on retrouve les managers
        List<Manager> managers = allPersons.stream()
                .filter(person -> person instanceof Manager)
                .map(person -> (Manager) person)
                .collect(Collectors.toList());

        assertThat(managers.size(), equalTo(1));
        assertThat(managers.get(0).getId(), equalTo(3L));
        assertThat(managers.get(0).getFirstName(), equalTo("Julien"));

        //et les autres non manager
        List<Person> others = allPersons.stream()
                .filter(person -> !(person instanceof Manager))
                .collect(Collectors.toList());
        assertThat(others.size(), equalTo(2));

    }

    @Test
    public void findAllManagersShouldReturnOnlyManagers() {
        //WHEN : call to dao method
        List<Manager> allManagers = personService.findAllManager();

        //THEN : on récupère que les managers (1 seul pour l'instant)
        assertThat(allManagers, is(notNullValue()));
        assertThat(allManagers.size(), equalTo(1));
        Manager manager = allManagers.get(0);
        assertThat(manager.getId(), equalTo(3L));
        assertThat(manager.getFirstName(), equalTo("Julien"));

        System.out.println("\n\n++++++++++++++++ Manager was : " + manager);
    }

    @Test
    public void managerShouldNavigateToConsultants() throws Exception {
        //GIVEN : a manager
        Manager manager = (Manager) personService.getPersonById(3L);

        //WHEN : on récupère les consultants
        List<Person> consultants = manager.getConsultants();

        //THEN : On vérifie qu'on retrouve les consultants du manager
        assertThat(consultants, is(notNullValue()));
        assertThat(consultants.size(), equalTo(2));

        //on vérifie que ça contient le consultant 1 et 2
        assertTrue(consultants.stream().anyMatch(person -> person.getId().equals(1L)));
        assertTrue(consultants.stream().anyMatch(person -> person.getId().equals(2L)));

        System.out.println("\n\n++++++++++++++++ Manager consultants : " + consultants);

    }

    @Test
//    @Rollback(false)
    public void saveOrUpdateShouldCreateNewPerson() throws Exception {
        //GIVEN : a new manager
        Manager stephane = new Manager();
        stephane.setFirstName("Stéphane");
        stephane.setLastName("Villette");
        stephane.setWorkTime(30);
        stephane.setFreeTime(70);
        stephane.setConsultants(personService.findAll());
        stephane.setClients(clientService.findAll());
        System.out.println("\n\n++++++++++++++++ Manager before saveOrUpdate : " + stephane);

        //WHEN : save entity
        assertThat(stephane.getId(), is(nullValue()));
        Person saved = personService.saveOrUpdate(stephane);

        //THEN : it's saved as expected!
        assertThat(saved.getId(), is(notNullValue()));
        System.out.println("\n\n++++++++++++++++ Manager after save : " + saved);

        //will load it from cache!
        Person cached = personService.getPersonById(saved.getId());
        assertThat(cached, is(notNullValue()));

        assertThat(cached.getFirstName(), equalTo("Stéphane"));
        System.out.println("\n\n++++++++++++++++ Manager in DB : " + cached);
        System.out.println("\n\n++++++++++++++++ Manager in DB clients  : " + cached.getClients());
        System.out.println("\n\n++++++++++++++++ Manager in DB consultants  : " + ((Manager)cached).getConsultants());

        System.out.println("\n\n++++++++++++++++ STOOOOP Pourquoi ça ne lance pas des insert dans mission???? => active Rollback(false) sur le test pour voir..");

    }

    /**
     * pas besoin d'appeler explicitement persist!
     */
    @Test
    @Rollback(false)
    public void updateWorkTimeShouldUpdateEntity() throws Exception {
        //GIVEN : a Manager in db
        Manager julien = (Manager) personService.getPersonById(3L);
        System.out.println("\n\n++++++++++++++++ Before updateWorkTime  : " + julien);

        //WHEN : we update worktime
        personService.updateWorkTime(julien, 100);

        //THEN : we check indb instance is updated
        assertEquals(100, (((Manager) personService.getPersonById(3L))).getWorkTime().intValue());
    }

    @Test
    @Rollback(false)
    public void detachShouldDisableHibernate() throws Exception {
        //GIVEN : an existent manager
        Manager julien = (Manager) personService.getPersonById(3L);
        Integer initialWT = julien.getWorkTime();
        System.out.println("\n\n++++++++++++++++ Before detach  : " + julien);

        //WHEN : entity is detached
        personService.detach(julien);
        personService.updateWorkTime(julien, 100);

        //THEN : check not updated in db
        Manager indb = (Manager) personService.getPersonById(3L);
        System.out.println("\n\n++++++++++++++++ in db  after detach : " + indb);
        assertNotEquals(100, indb.getWorkTime().intValue());
        assertEquals(initialWT, indb.getWorkTime());

        //WHEN : re attach by merge object and update value
        julien = (Manager) personService.saveOrUpdate(julien);
        personService.updateWorkTime(julien, 200);

        //THEN : la valeur en db est à jour
        indb = (Manager) personService.getPersonById(3L);
        System.out.println("\n\n++++++++++++++++ value in db after attach : " + indb);
        assertEquals(200, indb.getWorkTime().intValue());
        assertNotEquals(initialWT, indb.getWorkTime());


    }

}
