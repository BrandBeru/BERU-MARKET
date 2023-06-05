package org.beru.market.persistence;

import org.beru.market.domain.Client;
import org.beru.market.domain.repository.ClientRepository;
import org.beru.market.persistence.crud.ClienteCrudRepository;
import org.beru.market.persistence.entity.Cliente;
import org.beru.market.persistence.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository implements ClientRepository {
    @Autowired
    private ClienteCrudRepository clienteCrudRepository;
    @Autowired
    private ClientMapper mapper;
    @Override
    public List<Client> getAll() {
        return mapper.toClients((List<Cliente>) clienteCrudRepository.findAll());
    }

    @Override
    public Optional<Client> getById(String id) {
        return clienteCrudRepository.findById(id)
                .map(cliente -> mapper.toClient(cliente));
    }

    @Override
    public Optional<Client> getByEmail(String email) {
        return clienteCrudRepository.findByCorreoElectronico(email)
                .map(cliente -> mapper.toClient(cliente));
    }

    @Override
    public Optional<List<Client>> getByName(String name) {
        return clienteCrudRepository.findByNombre(name)
                .map(clientes -> mapper.toClients(clientes));
    }

    @Override
    public Client save(Client client) {
        return mapper.toClient(clienteCrudRepository.save(mapper.toCliente(client)));
    }

    @Override
    public void delete(String id) {
        clienteCrudRepository.deleteById(id);
    }
}
