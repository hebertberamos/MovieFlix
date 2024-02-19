package com.devsuperior.movieflix.controllers;

import com.devsuperior.movieflix.dtos.UserDTO;
import com.devsuperior.movieflix.servicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/profile")
    public ResponseEntity<UserDTO> getProfile(){
        UserDTO dto = service.getProfile();
        return ResponseEntity.ok().body(dto);
    }

}
