package net.fachrul;

import org.pmw.tinylog.Logger;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.core.Is.is;

public class FilmsTest extends BaseAPI {
    @Test
    public void getListFilms(){
        String response = when().
                                get(URLfilms).
                            then().
                                statusCode(200).
                                body("results.size()", is(7)).
                                body("results[0].title", is("A New Hope")).
                                body(matchesJsonSchemaInClasspath("films-schema.json")).
                                extract().response().asString();

        Logger.info("Response:");
        Logger.info(response);

    }
}
