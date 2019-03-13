package com.endresynnes.movie.repositories;

import com.endresynnes.movie.models.MovieEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<MovieEntity, Long> {

    /**
     * You only need to write a method name describing what you want and how you want to filter the response.
     *
     * start with: "findAll" to say that you want to find all and not only one
     * then set your filters like here: "ByAgeLimit". This will then given an integer find all movies matching that requirement.
     * take a look at this link for more inspiration: https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
     *
     * @param ageLimit age limit of a movie
     * @return List of movies matching the age limit
     */
    Iterable<MovieEntity> findAllByAgeLimit(int ageLimit);

    /**
     * You can also create methods for checking if something already exists in the database
     * @param title movie title
     * @return true or false if the movie with that title exists
     */
    boolean existsByTitle(String title);

}
