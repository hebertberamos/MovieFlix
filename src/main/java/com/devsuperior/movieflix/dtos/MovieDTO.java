package com.devsuperior.movieflix.dtos;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

public class MovieDTO {

    private Long id;
    private String title;
    private String subTitle;
    private Integer releaseYear;
    private String imgUri;
    private String synopsis;
    private Long genreId;
    private List<ReviewDTO> reviews = new ArrayList<>();

    public MovieDTO() {}

    public MovieDTO(Long id, String title, String subTitle, Integer releaseYear, String imgUri, String synopsis, Long genreId) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.releaseYear = releaseYear;
        this.imgUri = imgUri;
        this.synopsis = synopsis;
        this.genreId = genreId;
    }

    public MovieDTO(Movie entity) {
        id = entity.getId();
        title = entity.getTitle();
        subTitle = entity.getSubTitle();
        releaseYear = entity.getReleaseYear();
        imgUri = entity.getImgUri();
        synopsis = entity.getSynopsis();
        genreId = entity.getGenre().getId();
    }

    public MovieDTO(Movie entity, List<Review> reviews){
        this(entity);
        reviews.forEach(reviewDto -> this.reviews.add(new ReviewDTO(reviewDto)));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getImgUri() {
        return imgUri;
    }

    public void setImgUri(String imgUri) {
        this.imgUri = imgUri;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public List<ReviewDTO> getReviews() {
        return reviews;
    }
}
