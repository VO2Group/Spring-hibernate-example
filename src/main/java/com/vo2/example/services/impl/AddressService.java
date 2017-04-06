package com.vo2.example.services.impl;

import com.vo2.example.dao.IAddressDAO;
import com.vo2.example.model.Address;
import com.vo2.example.services.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by VO2 on 04/04/2017.
 */
@Service
@Transactional
public class AddressService implements IAddressService {

    @Autowired
    private IAddressDAO addressDAO;

    @Override
    public Address getAddressById(Long id) {
        return addressDAO.findAddressById(id);
    }
}
