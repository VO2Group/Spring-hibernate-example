package com.vo2.example;

import com.vo2.example.model.Client;
import com.vo2.example.model.Person;
import com.vo2.example.services.IPersonService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mehdi
 */
public class ApplicationRunner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext appContext =
    	  new ClassPathXmlApplicationContext("config/Context.xml");
        
        IPersonService personService = appContext.getBean(IPersonService.class, "personService");
        
        //Fetch Person
        long id = 1;
        Person p = personService.getPersonById(id);
        System.out.println("Person with id=" + id + " is " + p.getFirstName());
        
        //Fetch clients of the person
        List<Client> clients = personService.getPersonClients(id);
        System.out.println("Les client de " + p.getFirstName() + " sont: " + clients);
        
        //Search person by String
        String keyword = "Amine";
        System.out.println("Recherche personne avec le mot clé: " + keyword);
        List<Person> persons = personService.getPersonsByName(keyword);
        System.out.println("Resultat de la recherche sur nom/ prénom: " + persons);
        
    }
    
}
