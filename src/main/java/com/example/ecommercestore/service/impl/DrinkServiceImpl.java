package com.example.ecommercestore.service.impl;

import com.example.ecommercestore.dto.DrinkDto;
import com.example.ecommercestore.entity.Drink;
import com.example.ecommercestore.exception.ResourceNotFoundException;
import com.example.ecommercestore.repository.DrinkRepository;
import com.example.ecommercestore.service.DrinkService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DrinkServiceImpl implements DrinkService {
    private DrinkRepository drinkRepository;
    private ModelMapper modelMapper;


    @Override
    public DrinkDto addDrink(DrinkDto drinkDto) {
        drinkDto.setCategory("drink");
        Drink drink = modelMapper.map(drinkDto, Drink.class);
        Drink savedDrink = drinkRepository.save(drink);
        DrinkDto savedDrinkDto = modelMapper.map(savedDrink, DrinkDto.class);
        return savedDrinkDto;
    }

    @Override
    public DrinkDto getDrinkById(Long id) {
        Drink drink = drinkRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Drink not found with id: " + id));
        return modelMapper.map(drink, DrinkDto.class);
    }

    @Override
    public List<DrinkDto> getAllDrinks() {
        List<Drink> drinks = drinkRepository.findAll();
        return drinks.stream().map((drink) -> modelMapper.map(drink, DrinkDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public DrinkDto updateDrink(DrinkDto drinkDto, Long id) {
        Drink drink = drinkRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Drinks not found with id: " + id));
        drink.setName(drinkDto.getName());
        drink.setPrice(drinkDto.getPrice());
        drink.setImage(drinkDto.getImage());
        drink.setCategory("drink");
        drink.setExpiryDate(drinkDto.getExpiryDate());
        drink.setFlavour(drinkDto.getFlavour());

        Drink updatedDrink = drinkRepository.save(drink);
        return modelMapper.map(updatedDrink, DrinkDto.class);
    }

    @Override
    public void deleteDrink(Long id) {
        Drink drink = drinkRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Drinks not found with id: " + id));
        drinkRepository.deleteById(id);
    }


}
