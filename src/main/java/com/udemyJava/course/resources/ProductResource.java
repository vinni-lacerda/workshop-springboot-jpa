package com.udemyJava.course.resources;

import com.udemyJava.course.entities.Product;
import com.udemyJava.course.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductResource {
    @Autowired
    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> list = productService.findAllProducts();
         return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product obj = productService.findProductById(id);
        return ResponseEntity.ok().body(obj);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.deletProductById(id);
        return ResponseEntity.noContent().build();
    }
}
