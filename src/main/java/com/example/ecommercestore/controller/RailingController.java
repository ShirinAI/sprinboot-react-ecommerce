package com.example.ecommercestore.controller;

import com.example.ecommercestore.dto.RailingDto;
import com.example.ecommercestore.service.RailingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("products/railings")
@AllArgsConstructor
public class RailingController {
    private RailingService railingService;

    @PostMapping
    public ResponseEntity<RailingDto> addRailing(@RequestBody RailingDto railingDto){
        RailingDto savedRailing = railingService.addRailing(railingDto);
        return new ResponseEntity<>(savedRailing, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<RailingDto> getRailing(@PathVariable("id") Long railingId){
        RailingDto railingDto = railingService.getRailingById(railingId);
        return new ResponseEntity<>(railingDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RailingDto>> getAllRailings(){
        List<RailingDto> railings = railingService.getAllRailings();
        return new ResponseEntity<>(railings, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<RailingDto> updateRailing(@RequestBody RailingDto railingDto, @PathVariable("id")Long railingId){
        RailingDto updatedRailing = railingService.updateRailing(railingDto, railingId);
        return ResponseEntity.ok(updatedRailing);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRailing(@PathVariable("id") Long railingId){
        railingService.deleteRailing(railingId);
        return ResponseEntity.ok("Railing was deleted successfully.");
    }
}
