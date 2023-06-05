package org.beru.market.persistence;

import org.beru.market.domain.Product;
import org.beru.market.domain.repository.ProductRepository;
import org.beru.market.persistence.crud.ProductoCrudRepository;
import org.beru.market.persistence.entity.Producto;
import org.beru.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;
    @Override
    public List<Product> getAll() {
        return mapper.toProducts((List<Producto>) productoCrudRepository.findAll());
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        return Optional.of(mapper.toProducts(productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId)));
    }

    @Override
    public Optional<List<Product>> getScarceProducts(int quantity) {
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity,true)
                .map(productos -> mapper.toProducts(productos));
    }

    @Override
    public Optional<Product> getProduct(int id) {
        return productoCrudRepository.findById(id)
                .map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        return mapper.toProduct(productoCrudRepository.save(mapper.toProducto(product)));
    }

    @Override
    public void delete(int id) {
        productoCrudRepository.deleteById(id);
    }
}
