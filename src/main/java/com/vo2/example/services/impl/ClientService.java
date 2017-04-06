package com.vo2.example.services.impl;

import com.vo2.example.dao.IClientDAO;
import com.vo2.example.model.Client;
import com.vo2.example.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    @Override
    public List<Client> findAll() {
        return clientDAO.findAll();
    }
}
