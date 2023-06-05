package org.beru.market.persistence;

import org.beru.market.domain.Admin;
import org.beru.market.domain.repository.AdminRepository;
import org.beru.market.persistence.crud.AdminCrudRepository;
import org.beru.market.persistence.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AdministradorRepository implements AdminRepository {
    @Autowired
    private AdminCrudRepository adminCrudRepository;
    @Autowired
    private AdminMapper mapper;
    @Override
    public Optional<Admin> getByEmailAndPassword(String email, String password) {
        return adminCrudRepository.findByCorreoElectronicoAndContrasena(email, password)
                .map(administrador -> mapper.toAdmin(administrador));
    }

    @Override
    public Admin save(Admin admin) {
        return mapper.toAdmin(adminCrudRepository.save(mapper.toAdministrador(admin)));
    }
}
