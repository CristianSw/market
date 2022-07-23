package com.geekbrains.market.controllers;

import com.geekbrains.market.model.Product;
import com.geekbrains.market.repositories.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productRepository.getAllItems();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id){
        return productRepository.getProductById(id);
    }

    @PostMapping("/products")
    public void addNewProduct(@RequestBody Product product){
        productRepository.addNewProduct(product);
    }

    @DeleteMapping("/products")
    public void deleteAllProducts(){
        productRepository.deleteAllProducts();
    }

    @DeleteMapping("/products/{id}")
    public void deleteProductsById(@PathVariable Long id){
        productRepository.deleteItemById(id);
    }

}
