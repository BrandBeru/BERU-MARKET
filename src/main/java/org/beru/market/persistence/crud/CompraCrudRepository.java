package org.beru.market.persistence.crud;

import org.beru.market.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {
    Optional<List<Compra>> findByIdCliente(String idCliente);
    Optional<List<Compra>> findByFecha(LocalDateTime fecha);
}
