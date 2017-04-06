package com.vo2.example.dao.impl;

import com.vo2.example.dao.IAddressDAO;
import com.vo2.example.model.Address;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by VO2 on 04/04/2017.
 */
@Repository
public class AddressDAOImpl implements IAddressDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Address findAddressById(Long id) {
        return em.find(Address.class, id);
    }
}
