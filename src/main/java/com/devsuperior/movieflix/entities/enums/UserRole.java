package com.devsuperior.movieflix.entities.enums;

public enum UserRole {

    VISITOR("visitor"),
    MEMBER("member");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }

}
