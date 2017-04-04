package com.vo2.example.services;

import com.vo2.example.dao.IAddressDAO;
import com.vo2.example.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by VO2 on 04/04/2017.
 */
@Service
public class AddressService implements IAddressService {

    @Autowired
    private IAddressDAO addressDAO;

    @Override
    public Address getAddressById(Long id) {
        return addressDAO.findAddressById(id);
    }
}
