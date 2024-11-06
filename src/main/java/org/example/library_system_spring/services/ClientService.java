package org.example.library_system_spring.services;


import org.example.library_system_spring.entities.Client;
import org.example.library_system_spring.entities.Loan;
import org.example.library_system_spring.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAllClients(){
        return clientRepository.findAll();
    }
    public Client findById(Long id){
        Optional<Client> obj = clientRepository.findById(id);
        return obj.get();
    }
}
