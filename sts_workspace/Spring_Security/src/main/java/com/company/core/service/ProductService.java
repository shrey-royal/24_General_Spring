package com.company.core.service;

import com.company.core.entity.Product;
import java.util.List;

public interface ProductService {
    Product save(Product p);
    List<Product> getAll();
    Product getById(Long id);
}

