package org.beru.market.persistence.crud;

import org.beru.market.persistence.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteCrudRepository extends CrudRepository<Cliente, String> {
    Optional<Cliente> findByCorreoElectronico(String correoElectronico);
    Optional<List<Cliente>> findByNombre(String nombre);
}
