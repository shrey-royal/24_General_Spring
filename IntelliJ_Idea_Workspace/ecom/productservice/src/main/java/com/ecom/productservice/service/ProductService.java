package com.ecom.productservice.service;

import com.ecom.productservice.entity.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);
    List<Product> findAllProducts();
    Product findProductById(Long id);
    void deleteById(Long id);
}
