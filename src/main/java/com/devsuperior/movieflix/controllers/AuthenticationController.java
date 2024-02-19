package com.devsuperior.movieflix.controllers;

import com.devsuperior.movieflix.controllers.exceptions.FieldMessage;
import com.devsuperior.movieflix.dtos.LoginUserDTO;
import com.devsuperior.movieflix.dtos.RegisterUserDTO;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.UserRepository;
import com.devsuperior.movieflix.servicies.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    // Method to register new User
    @PostMapping("/register")
    private ResponseEntity register(@RequestBody @Valid RegisterUserDTO dto){
        // =>  Code to verify if the email don't exist in database
        List<FieldMessage> list = new ArrayList<>();
        if(repository.findByEmail(dto.getEmail()) != null){
            list.add(new FieldMessage("Email", "Email already exists in database"));
            return ResponseEntity.badRequest().build();
        }

        // =>  Encrypting password
        String passwordEcrypted = new BCryptPasswordEncoder().encode(dto.getPassword());

        // =>  Code to save new user in database
        User user = new User(dto.getName(), dto.getEmail(), passwordEcrypted, dto.getRole());
        repository.save(user);

        return ResponseEntity.ok().build();
    }

    // Method to login User.
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginUserDTO dto){

        // =>  Catch User.
        var usernamePassword = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword());
        var auth = authenticationManager.authenticate(usernamePassword);

        // =>  Generate token
        String token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok().body("Token: " + token);
    }

}
