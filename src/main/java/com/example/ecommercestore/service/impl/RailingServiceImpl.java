package com.example.ecommercestore.service.impl;

import com.example.ecommercestore.dto.RailingDto;
import com.example.ecommercestore.entity.Railing;
import com.example.ecommercestore.exception.ResourceNotFoundException;
import com.example.ecommercestore.repository.RailingRepository;
import com.example.ecommercestore.service.RailingService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RailingServiceImpl implements RailingService {
    private RailingRepository railingRepository;
    private ModelMapper modelMapper;


    @Override
    public RailingDto addRailing(RailingDto railingDto) {
        railingDto.setCategory("railing");
        Railing railing = modelMapper.map(railingDto, Railing.class);
        Railing savedRailing = railingRepository.save(railing);
        RailingDto savedRailingDto = modelMapper.map(savedRailing, RailingDto.class);
        return savedRailingDto;
    }

    @Override
    public RailingDto getRailingById(Long id) {
        Railing railing = railingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Railing not found with id: " + id));
        return modelMapper.map(railing, RailingDto.class);
    }

    @Override
    public List<RailingDto> getAllRailings() {
        List<Railing> railings = railingRepository.findAll();
        return railings.stream().map((railing) -> modelMapper.map(railing, RailingDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public RailingDto updateRailing(RailingDto railingDto, Long id) {
        Railing railing = railingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Railings not found with id: " + id));
        railing.setName(railingDto.getName());
        railing.setPrice(railingDto.getPrice());
        railing.setImage(railingDto.getImage());
        railing.setColour(railingDto.getColour());
        railing.setCategory("railing");
        Railing updatedRailing = railingRepository.save(railing);
        return modelMapper.map(updatedRailing, RailingDto.class);
    }

    @Override
    public void deleteRailing(Long id) {
        Railing railing = railingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Railings not found with id: " + id));
        railingRepository.deleteById(id);
    }

}
