package org.zero2one.produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zero2one.produtos.model.Product;

import java.util.Collection;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Collection<Product> findAllByDescription(String description);
}
