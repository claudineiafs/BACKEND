package org.zero2one.produtos.controller;

import org.springframework.web.bind.annotation.*;
import org.zero2one.produtos.model.Product;

import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private Map<String, Product> products = new HashMap<>();

    public ProductsController() {
        Product celular = new Product();
        celular.setId("1A");
        celular.setDescription("Novo Moto X 2");
        celular.setName("Moto X");
        celular.setPrice(1999.99);

        Product notebook = new Product();
        celular.setId("1B");
        celular.setDescription("Dell i9");
        celular.setName("Dell");
        celular.setPrice(9999.99);

        products.put(celular.getId(), celular);
        products.put(notebook.getId(), notebook);
    }

    @GetMapping
    public Collection<Product> get() {
        return products.values();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable("id") String id){
        return products.get(id);
    }

}

