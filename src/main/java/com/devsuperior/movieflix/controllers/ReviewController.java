package com.devsuperior.movieflix.controllers;

import com.devsuperior.movieflix.dtos.ReviewDTO;
import com.devsuperior.movieflix.servicies.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/reviews")
public class ReviewController {

    @Autowired
    private ReviewService service;

    @GetMapping
    public ResponseEntity<List<ReviewDTO>> findAll(){
        List<ReviewDTO> dtos = service.findAll();
        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDTO> findByID(@PathVariable Long id){
        ReviewDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping("/create")
    public ResponseEntity insert(@RequestBody @Valid ReviewDTO dto){
        dto = service.insert(dto);
        return ResponseEntity.ok().body(dto);
    }
}
