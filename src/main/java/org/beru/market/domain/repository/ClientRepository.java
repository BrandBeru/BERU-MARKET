package org.beru.market.domain.repository;

import org.beru.market.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    List<Client> getAll();
    Optional<Client> getById(String id);
    Optional<Client> getByEmail(String email);
    Optional<List<Client>> getByName(String name);
    Client save(Client client);
    void delete(String id);
}
