package com.devsuperior.movieflix.dtos;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;

import java.util.ArrayList;
import java.util.List;

public class GenreDTO {

    private Long id;
    private String name;
    private List<Movie> movies = new ArrayList<>();

    public GenreDTO() {}

    public GenreDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public GenreDTO (Genre entity){
        id = entity.getId();
        name = entity.getName();
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

    public List<Movie> getMovies() {
        return movies;
    }
}
