package com.geekbrains.market.repositories;

import com.geekbrains.market.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> items;

    @PostConstruct
    public void init(){
        this.items = new ArrayList<>(List.of(
                Product.builder().id(1L).title("Milk").price(29.99).build(),
                Product.builder().id(2L).title("Bread").price(9.56).build()
        ));
    }

    public List<Product> getAllItems(){
        return Collections.unmodifiableList(items);
    }

    public Product getProductById(Long id){
        return items.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException("No product find with " + id + "id."));
    }

    public void addNewProduct(Product product){
        product.setId((long) items.size() + 1);
        items.add(product);
    }

    public void deleteAllProducts(){
        items.clear();
    }

    public void deleteItemById(Long id){
        items.removeIf(product -> product.getId().equals(id));
    }




}
