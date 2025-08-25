package com.ecom.productservice.service;

import com.ecom.productservice.entity.Product;
import com.ecom.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private ProductRepository repo;

    @Override
    public Product save(Product product) {
        return repo.save(product);
    }

    @Override
    public List<Product> findAllProducts() {
        return repo.findAll();
    }

    @Override
    public Product findProductById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Product not found!"));
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
