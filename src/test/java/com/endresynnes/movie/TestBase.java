package com.endresynnes.movie;

import com.endresynnes.movie.models.MovieDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
abstract class TestBase {


    @LocalServerPort
    protected int port = 0;

    protected String path = "/movies";
    protected int age = 15;

    @Before
    public void setUp() {

        baseURI = "http://localhost";
        RestAssured.port = port;
        enableLoggingOfRequestAndResponseIfValidationFails();

        createDefaultMovie();

    }

    private void createDefaultMovie() {
        var movieDto = new  MovieDto();
        movieDto.setAgeLimit(age);
        movieDto.setTitle("Indiana Jones");

        given()
                .contentType(ContentType.JSON)
                .body(movieDto)
                .post(path);
    }
}