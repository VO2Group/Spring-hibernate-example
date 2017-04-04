package com.vo2.example.dao;

import com.vo2.example.model.Address;

/**
 * Created by VO2 on 04/04/2017.
 */
public interface IAddressDAO {

    Address findAddressById(Long id);
}
