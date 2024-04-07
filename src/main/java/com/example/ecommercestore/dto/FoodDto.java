package com.example.ecommercestore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDto extends ProductDto{
    private LocalDate expiryDate;
}
