package com.devsuperior.movieflix.servicies.exceptions;

public class ResourcesNotFoundException extends RuntimeException{

    public ResourcesNotFoundException(String message) {
        super(message);
    }

}
