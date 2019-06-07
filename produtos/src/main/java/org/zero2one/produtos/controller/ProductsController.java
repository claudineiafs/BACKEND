package org.zero2one.produtos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zero2one.produtos.model.Product;
import org.zero2one.produtos.repository.ProductRepository;

import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository repository;



    @GetMapping
    public Collection<Product> get(@RequestParam(required = false, value = "description") String description) {
        if (description != null) {
            return repository.findAllByDescription(description);
        }
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") String id){
        Product product = repository.findById(id).orElse(null);
        if(product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return repository.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable("id") String id) {
        repository.deleteById(id);
    }

}

