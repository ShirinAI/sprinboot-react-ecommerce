package com.example.ecommercestore.repository;

import com.example.ecommercestore.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
