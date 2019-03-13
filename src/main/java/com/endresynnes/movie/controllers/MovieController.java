package com.endresynnes.movie.controllers;

import com.endresynnes.movie.models.MovieDto;
import com.endresynnes.movie.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    /**
     * Endpoint for getting movies.
     * @param age query parameter for age limit, not required.
     * @return list of movies
     */
    @GetMapping
    public ResponseEntity<List<MovieDto>> getMovies(
            @RequestParam(value = "age", required = false) Integer age){
        return ResponseEntity.ok(movieService.getMovies(age));
    }

    /**
     * Endpoint for creating movie
     * @param movieDto http body object representing all fields for a movie object
     * @return the id of the newly created movie
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieDto> createMovie(@RequestBody MovieDto movieDto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(movieService.createMovie(movieDto));
    }
}
