package com.devsuperior.movieflix.servicies;

import com.devsuperior.movieflix.dtos.MovieDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.servicies.exceptions.ResourcesNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    // Find all paged
    @Transactional(readOnly = true)
    public Page<MovieDTO> findAllPaged(Pageable pageable){
        Page<Movie> movies = repository.findAll(pageable);
        return movies.map(x -> new MovieDTO(x));
    }

    @Transactional(readOnly = true)
    public MovieDTO findById(Long id){
        Optional<Movie> optional = repository.findById(id);
        Movie movie = optional.orElseThrow(() -> new ResourcesNotFoundException(("Id not found")));
        return new MovieDTO(movie, movie.getReviews());
    }

}
