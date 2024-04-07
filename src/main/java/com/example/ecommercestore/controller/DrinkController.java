package com.example.ecommercestore.controller;

import com.example.ecommercestore.dto.DrinkDto;
import com.example.ecommercestore.service.DrinkService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("products/drinks")
@AllArgsConstructor
public class DrinkController {
    private DrinkService drinkService;

    @PostMapping
    public ResponseEntity<DrinkDto> addDrink(@RequestBody DrinkDto drinkDto){
        DrinkDto savedDrink = drinkService.addDrink(drinkDto);
        return new ResponseEntity<>(savedDrink, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<DrinkDto> getDrink(@PathVariable("id") Long drinkId){
        DrinkDto drinkDto = drinkService.getDrinkById(drinkId);
        return new ResponseEntity<>(drinkDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DrinkDto>> getAllDrinks(){
        List<DrinkDto> drinks = drinkService.getAllDrinks();
        return new ResponseEntity<>(drinks, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<DrinkDto> updateDrink(@RequestBody DrinkDto drinkDto, @PathVariable("id")Long drinkId){
        DrinkDto updatedDrink = drinkService.updateDrink(drinkDto, drinkId);
        return ResponseEntity.ok(updatedDrink);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDrink(@PathVariable("id") Long drinkId){
        drinkService.deleteDrink(drinkId);
        return ResponseEntity.ok("Drink was deleted successfully.");
    }
}
