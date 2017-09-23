package net.fachrul;

import io.restassured.RestAssured;
import org.pmw.tinylog.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class BaseAPI {
    protected String URL = "https://swapi.co/api";
    protected String URLpeople = "/people/1/";
    protected String URLfilms = "/films/";

    @BeforeSuite
    public void testSetup(){
        Logger.info("Setup the test suite");
        RestAssured.baseURI = URL;
    }

    @AfterSuite
    public void testTeardown(){
        Logger.info("Teardown the test suite");
    }
}
