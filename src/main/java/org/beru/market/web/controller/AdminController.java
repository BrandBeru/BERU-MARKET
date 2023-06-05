package org.beru.market.web.controller;

import org.beru.market.domain.Admin;
import org.beru.market.domain.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @GetMapping("/")
    public ResponseEntity<Admin> getByEmailAndPassword(String email, String password){
        return adminService.getByEmailAndPassword(email,password)
                .map(admin -> new ResponseEntity<>(admin, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/{}")
    ResponseEntity<Admin> save(@RequestBody Admin admin){
        return new ResponseEntity<>(adminService.save(admin), HttpStatus.OK);
    }
}
