package com.endresynnes.movie.services;

import com.endresynnes.movie.models.MovieDto;
import com.endresynnes.movie.repositories.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.endresynnes.movie.utils.MovieConverter.dtoToEntity;
import static com.endresynnes.movie.utils.MovieConverter.entityToDto;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    private static final Logger LOG = LoggerFactory.getLogger(MovieService.class);


    /**
     * Creating a Movie object
     * @param movieDto Object representing a movie
     * @return Movie object with just a id to locate it
     */
    public MovieDto createMovie(MovieDto movieDto){

        validateMovieDto(movieDto);

        if (movieRepository.existsByTitle(movieDto.getTitle())) {
            LOG.warn("Movie already exists");
            throw new IllegalStateException("Movie with title already exists");
        }

        var id = movieRepository.save(dtoToEntity(movieDto)).getId();

        return new MovieDto(id.toString());
    }

    /**
     * Getting movies
     * @param ageLimit number representing age limit
     * @return List of movies
     */
    public List<MovieDto> getMovies(Integer ageLimit){
        if (ageLimit == null) return entityToDto(movieRepository.findAll());

        return entityToDto(movieRepository.findAllByAgeLimit(ageLimit));
    }

    /**
     * Validating the Movie request object to make sure the user don't create a movie without a title.
     * @param movieDto object representing a movie
     */
    private void validateMovieDto(MovieDto movieDto){

        if (movieDto.getTitle() == null) {
            LOG.warn("Title is missing");
            throw new IllegalStateException("Missing movie title");
        }
    }
}
