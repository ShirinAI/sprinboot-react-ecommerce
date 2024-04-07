package com.example.ecommercestore.service;

import com.example.ecommercestore.dto.RailingDto;

import java.util.List;

public interface RailingService {
    RailingDto addRailing(RailingDto railingDto);
    RailingDto getRailingById(Long id);
    List<RailingDto> getAllRailings();
    RailingDto updateRailing(RailingDto railingDto, Long id);
    void deleteRailing(Long id);
}
