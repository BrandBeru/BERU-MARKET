package org.beru.market.domain.service;

import org.beru.market.domain.Purchase;
import org.beru.market.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;
    public List<Purchase> getAll(){
        return purchaseRepository.getAll();
    }
    public Optional<List<Purchase>> getByClient(String clientId){
        return purchaseRepository.getByClient(clientId);
    }
    public Optional<List<Purchase>> getByDate(LocalDateTime date){
        return purchaseRepository.getByDate(date);
    }
    public Purchase save(Purchase purchase){
        return purchaseRepository.save(purchase);
    }
}
