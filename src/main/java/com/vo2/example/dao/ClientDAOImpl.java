package com.vo2.example.dao;

import com.vo2.example.model.Client;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by VO2 on 04/04/2017.
 */
@Repository
public class ClientDAOImpl implements IClientDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Client findClientById(Long id) {
        return em.find(Client.class, id);
    }
}
