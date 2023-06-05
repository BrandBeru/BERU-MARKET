package org.beru.market.domain.repository;

import org.beru.market.domain.Admin;

import java.util.Optional;

public interface AdminRepository {
    Optional<Admin> getByEmailAndPassword(String email, String password);
    Admin save(Admin admin);
}
