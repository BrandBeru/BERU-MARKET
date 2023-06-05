package org.beru.market.persistence.crud;

import org.beru.market.persistence.entity.Administrador;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AdminCrudRepository extends CrudRepository<Administrador, Integer> {
    Optional<Administrador> findByCorreoElectronicoAndContrasena(String correoElectronico, String contrasena);
}
