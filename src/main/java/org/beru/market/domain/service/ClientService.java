package org.beru.market.domain.service;

import org.beru.market.domain.Client;
import org.beru.market.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    public Optional<Client> getById(String id){
        return clientRepository.getById(id);
    }
    public Optional<Client> getByEmail(String email){
        return clientRepository.getByEmail(email);
    }
    public Optional<List<Client>> getByName(String name){
        return clientRepository.getByName(name);
    }
    public Client save(Client client){
        return clientRepository.save(client);
    }
    public boolean delete(String id){
        return getById(id).map(client -> {
            clientRepository.delete(id);
            return true;
        }).orElse(false);
    }
}
