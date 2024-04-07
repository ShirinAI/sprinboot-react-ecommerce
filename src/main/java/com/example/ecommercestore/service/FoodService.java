package com.example.ecommercestore.service;

import com.example.ecommercestore.dto.FoodDto;

import java.util.List;

public interface FoodService {
    FoodDto addFood(FoodDto foodDto);
    FoodDto getFoodById(Long id);
    List<FoodDto> getAllFoods();
    FoodDto updateFood(FoodDto foodDto, Long id);
    void deleteFood(Long id);
}
