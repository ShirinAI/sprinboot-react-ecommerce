package com.example.ecommercestore.controller;

import com.example.ecommercestore.dto.FoodDto;
import com.example.ecommercestore.service.FoodService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("products/foods")
@AllArgsConstructor
public class FoodController {
    private FoodService foodService;

    @PostMapping
    public ResponseEntity<FoodDto> addFood(@RequestBody FoodDto foodDto){
        FoodDto savedFood = foodService.addFood(foodDto);
        return new ResponseEntity<>(savedFood, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<FoodDto> getFood(@PathVariable("id") Long foodId){
        FoodDto foodDto = foodService.getFoodById(foodId);
        return new ResponseEntity<>(foodDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FoodDto>> getAllFoods(){
        List<FoodDto> foods = foodService.getAllFoods();
        return new ResponseEntity<>(foods, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<FoodDto> updateFood(@RequestBody FoodDto FoodDto, @PathVariable("id")Long FoodId){
        FoodDto updatedFood = foodService.updateFood(FoodDto, FoodId);
        return ResponseEntity.ok(updatedFood);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFood(@PathVariable("id") Long FoodId){
        foodService.deleteFood(FoodId);
        return ResponseEntity.ok("Food was deleted successfully.");
    }

}