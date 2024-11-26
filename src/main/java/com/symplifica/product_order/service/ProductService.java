package com.symplifica.product_order.service;

import com.symplifica.product_order.entity.Product;
import com.symplifica.product_order.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> findById(Integer productId) {
        return productRepository.findById(productId);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
