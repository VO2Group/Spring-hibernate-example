package com.vo2.example.services;

import com.vo2.example.model.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by VO2 on 04/04/2017.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:config/Context.xml")
public class AddressServiceTest {

    @Autowired
    private IAddressService addressService;

    @Test
    public void getAddressByIdShouldLoadAddress() throws Exception {
        Address address = addressService.getAddressById(1L);
        assertThat(address, is(not(nullValue())));
        assertThat(address.getCountry(), is(not(nullValue())));
        assertThat(address.getCountry().getName(), is(equalTo("France")));
    }

}
