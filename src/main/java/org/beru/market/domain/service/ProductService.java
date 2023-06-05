package org.beru.market.domain.service;

import org.beru.market.domain.Product;
import org.beru.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> getAll(){
        return productRepository.getAll();
    }
    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }
    public Optional<List<Product>> getScarceProducts(int quantity){
        return productRepository.getScarceProducts(quantity);
    }
    public Optional<Product> getProduct(int id){
        return productRepository.getProduct(id);
    }
    public Product save(Product product){
        return productRepository.save(product);
    }
    public boolean delete(int id){
        return productRepository.getProduct(id).map(product -> {
            productRepository.delete(id);
            return true;
        }).orElse(false);
    }

}
