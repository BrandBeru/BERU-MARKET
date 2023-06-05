package org.beru.market.web.controller;

import org.beru.market.domain.Client;
import org.beru.market.domain.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    ClientService clientService;
    @GetMapping("/")
    public ResponseEntity<List<Client>> getAll(){
        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
    }
    public ResponseEntity<Client> getById(String id){
        return clientService.getById(id)
                .map(client -> new ResponseEntity<>(client, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/{email}")
    public ResponseEntity<Client> getByEmailAndPassword(@PathVariable String email){
        return clientService.getByEmail(email)
                .map(client -> new ResponseEntity<>(client, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/client/{name}")
    public ResponseEntity<List<Client>> getByName(@PathVariable String name){
        return clientService.getByName(name)
                .map(client -> new ResponseEntity<>(client, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/")
    public ResponseEntity<Client> save(@RequestBody Client client){
        return new ResponseEntity<>(clientService.save(client), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        return new ResponseEntity<>(clientService.delete(id), HttpStatus.OK);
    }
}
