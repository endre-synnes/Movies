package com.endresynnes.movie;

import io.restassured.http.ContentType;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class MovieApplicationTests extends TestBase{


    @Test
    public void testGetMoviesByAge() {


        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .get(path + "/" + age)
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("data.size" , CoreMatchers.equalTo(1))
                .extract().body().jsonPath().prettyPrint();

    }
}
