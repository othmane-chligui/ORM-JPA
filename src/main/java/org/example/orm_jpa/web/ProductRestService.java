package org.example.orm_jpa.web;

import org.example.orm_jpa.Entities.Product;
import org.example.orm_jpa.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestService {
    @Autowired
    private ProductRepo productRepo;
    @GetMapping("/products")
    public List<Product> products(){
        return productRepo.findAll();
    }

    @GetMapping("/products/{id}")
    public Product findProduct(@PathVariable Long id){
        Product product = productRepo.findById(id).orElse(null);
        return product;
    }
}
