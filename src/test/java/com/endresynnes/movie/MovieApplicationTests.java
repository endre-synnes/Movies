package com.endresynnes.movie;

import com.endresynnes.movie.models.MovieDto;
import io.restassured.http.ContentType;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertNotEquals;

public class MovieApplicationTests extends TestBase{


    @Test
    public void testGetMoviesByAgeWithNoMatch() {


        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .get(path + "?age=" + age + 1)
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("data.size" , CoreMatchers.equalTo(0))
                .extract().body().jsonPath().prettyPrint();

    }

    @Test
    public void createNewMovie() {

        var numberOfMovies = getMovies().length;

        var movieDto = new MovieDto();
        movieDto.setAgeLimit(age);
        movieDto.setTitle("Star Wars");

        given()
                .contentType(ContentType.JSON)
                .body(movieDto)
                .post(path);

        var numberOfMoviesAfterPost = getMovies().length;

        assertNotEquals(numberOfMovies, numberOfMoviesAfterPost);
    }


    private MovieDto[] getMovies(){
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .get(path)
                .then()
                .statusCode(HttpStatus.OK.value())
                .extract().body().as(MovieDto[].class);
    }
}
