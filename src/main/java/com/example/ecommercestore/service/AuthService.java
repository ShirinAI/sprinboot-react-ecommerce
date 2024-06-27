package com.example.ecommercestore.service;

import com.example.ecommercestore.dto.JwtAuthResponse;
import com.example.ecommercestore.dto.LoginDto;
import com.example.ecommercestore.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);
    JwtAuthResponse login(LoginDto loginDto);
}
