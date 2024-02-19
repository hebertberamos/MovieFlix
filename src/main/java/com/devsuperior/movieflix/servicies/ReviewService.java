package com.devsuperior.movieflix.servicies;

import com.devsuperior.movieflix.dtos.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.repositories.UserRepository;
import com.devsuperior.movieflix.servicies.exceptions.ResourcesNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @Transactional(readOnly = true)
    public List<ReviewDTO> findAll(){
        List<Review> reviews = repository.findAll();
        return reviews.stream().map(x -> new ReviewDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ReviewDTO findById(Long id){
        Optional<Review> optional = repository.findById(id);
        Review review = optional.orElseThrow(() -> new ResourcesNotFoundException("Id not found"));
        return new ReviewDTO(review);
    }

    public ReviewDTO insert(ReviewDTO dto){
        // =>  Verify if user are a MEMBER
        authenticationService.isMember();

        // =>  Get the User
       Optional<User> optionalUser = userRepository.findById(dto.getUserId());
        User user = optionalUser.orElseThrow(() -> new ResourcesNotFoundException("Unfortunately, it was not possible to find the user ID for the review reported in our database."));

        // =>  Get the Movie
        Optional<Movie> optionalMovie = movieRepository.findById(dto.getMovieId());
        Movie movie = optionalMovie.orElseThrow(() -> new ResourcesNotFoundException("Unfortunately, it was not possible to find the movie ID for the review reported in our database."));

        Review entityReview = new Review(dto.getText(), movie, user);
        repository.save(entityReview);

        return new ReviewDTO(entityReview);
    }
}
