package com.example.ecommercestore.service.impl;

import com.example.ecommercestore.dto.FoodDto;
import com.example.ecommercestore.dto.FoodDto;
import com.example.ecommercestore.entity.Food;
import com.example.ecommercestore.exception.ResourceNotFoundException;
import com.example.ecommercestore.repository.FoodRepository;
import com.example.ecommercestore.service.FoodService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FoodServiceImpl implements FoodService {
    private FoodRepository foodRepository;
    private ModelMapper modelMapper;


    @Override
    public FoodDto addFood(FoodDto foodDto) {
        foodDto.setCategory("food");
        Food food = modelMapper.map(foodDto, Food.class);
        Food savedFood = foodRepository.save(food);
        FoodDto savedFoodDto = modelMapper.map(savedFood, FoodDto.class);
        return savedFoodDto;
    }

    @Override
    public FoodDto getFoodById(Long id) {
        Food Food = foodRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Food not found with id: " + id));
        return modelMapper.map(Food, FoodDto.class);
    }

    @Override
    public List<FoodDto> getAllFoods() {
        List<Food> Foods = foodRepository.findAll();
        return Foods.stream().map((Food) -> modelMapper.map(Food, FoodDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public FoodDto updateFood(FoodDto foodDto, Long id) {
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Foods not found with id: " + id));
        food.setName(foodDto.getName());
        food.setPrice(foodDto.getPrice());
        food.setImage(foodDto.getImage());
        food.setCategory("food");
        food.setExpiryDate(foodDto.getExpiryDate());

        Food updatedFood = foodRepository.save(food);
        return modelMapper.map(updatedFood, FoodDto.class);
    }

    @Override
    public void deleteFood(Long id) {
        Food Food = foodRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Foods not found with id: " + id));
        foodRepository.deleteById(id);
    }

}
