package com.example.ecommercestore.repository;

import com.example.ecommercestore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
