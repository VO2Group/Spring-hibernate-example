package com.vo2.example.services;

import com.vo2.example.dao.IClientDAO;
import com.vo2.example.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by VO2 on 04/04/2017.
 */

@Service
@Transactional
public class ClientService implements IClientService {

    @Autowired
    private IClientDAO clientDAO;

    @Override
    public Client getClientById(Long id) {
        return clientDAO.findClientById(id);
    }
}
