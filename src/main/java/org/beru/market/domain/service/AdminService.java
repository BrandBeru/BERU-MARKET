package org.beru.market.domain.service;

import org.beru.market.domain.Admin;
import org.beru.market.domain.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    public Optional<Admin> getByEmailAndPassword(String email, String password){
        return adminRepository.getByEmailAndPassword(email,password);
    }
    public Admin save(Admin admin){
        return adminRepository.save(admin);
    }
}
