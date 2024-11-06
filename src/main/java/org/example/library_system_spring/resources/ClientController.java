package org.example.library_system_spring.resources;


import org.example.library_system_spring.entities.Client;
import org.example.library_system_spring.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    public List<Client> getAllClients(){
        return clientService.findAllClients();
    }

}
