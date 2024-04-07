package com.example.ecommercestore.repository;

import com.example.ecommercestore.entity.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkRepository extends JpaRepository<Drink, Long> {
}
