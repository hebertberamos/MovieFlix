package com.devsuperior.movieflix.dtos;

import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.entities.enums.UserRole;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String password;
    private UserRole role;
    private List<Review> reviews = new ArrayList<>();

    public UserDTO() {}

    public UserDTO(Long id, String name, String email, String password, UserRole role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public UserDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        password = entity.getPassword();
        role = entity.getRole();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public List<Review> getReviews() {
        return reviews;
    }
}
