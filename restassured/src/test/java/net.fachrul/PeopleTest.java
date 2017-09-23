package net.fachrul;

import org.pmw.tinylog.Logger;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;

public class PeopleTest extends BaseAPI {

    @Test
    public void getProfileLuke(){
        String response = when().
                            get(URLpeople).
                            then().
                                statusCode(200).
//                                body("$", containsString("19BBY")).
                                body("birth_year", is("19BBY")).
                                body("name", is("Luke Skywalker")).
                                body(matchesJsonSchemaInClasspath("people-schema.json")).
                        extract().response().asString();

        Logger.info("Response:");
        Logger.info(response);
    }
}
