package com.udemyJava.course.services;

import com.udemyJava.course.entities.Product;
import com.udemyJava.course.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }
    public Product findProductById(Long id){
        return productRepository.findById(id).get();
    }
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
    public void deletProductById(Long id){
        productRepository.deleteById(id);
    }
}
