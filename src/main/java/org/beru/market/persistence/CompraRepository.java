package org.beru.market.persistence;

import org.beru.market.domain.Purchase;
import org.beru.market.domain.repository.PurchaseRepository;
import org.beru.market.persistence.crud.CompraCrudRepository;
import org.beru.market.persistence.entity.Compra;
import org.beru.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {
    @Autowired
    private CompraCrudRepository compraCrudRepository;
    @Autowired
    private PurchaseMapper mapper;
    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Optional<List<Purchase>> getByDate(LocalDateTime date) {
        return compraCrudRepository.findByFecha(date)
                .map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getProductos().forEach(comprasProducto -> comprasProducto.setCompra(compra));
        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
}
