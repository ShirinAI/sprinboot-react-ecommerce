package com.example.ecommercestore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RailingDto extends ProductDto{
    private String colour;
    private String model;
}
