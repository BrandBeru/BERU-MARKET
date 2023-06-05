package org.beru.market.domain.repository;

import org.beru.market.domain.Purchase;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String clientId);
    Optional<List<Purchase>> getByDate(LocalDateTime date);
    Purchase save(Purchase purchase);
}
