package com.example.ecommercestore.service.impl;

import com.example.ecommercestore.dto.ProductDto;
import com.example.ecommercestore.entity.Product;
import com.example.ecommercestore.repository.ProductRepository;
import com.example.ecommercestore.service.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;
    ModelMapper modelMapper;



    @Override
    public List<ProductDto> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products.stream().map((product) -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }
}
