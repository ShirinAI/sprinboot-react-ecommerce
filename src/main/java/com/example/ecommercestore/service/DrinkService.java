package com.example.ecommercestore.service;

import com.example.ecommercestore.dto.DrinkDto;
import com.example.ecommercestore.entity.Drink;

import java.util.List;

public interface DrinkService {
    DrinkDto addDrink(DrinkDto drinkDto);
    DrinkDto getDrinkById(Long id);
    List<DrinkDto> getAllDrinks();
    DrinkDto updateDrink(DrinkDto drinkDto, Long id);
    void deleteDrink(Long id);
}
