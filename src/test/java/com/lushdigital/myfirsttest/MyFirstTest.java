package com.lushdigital.myfirsttest;


import com.lushdigital.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class MyFirstTest extends TestBase {

    @Test
    public void getAllProductInfo() {
        Response response = given()
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleProduct() {
        Response response = given()
                .when()
                .get("/2");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void searchProductWithParameter() {
        Response response = given()
                .pathParam("id", 3)
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void searchProductWithQueryParameter() {
        Response response = given()
                .queryParam("name", "Blueberry")
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void searchProductWithQueryParameter1() {
        Response response = given()
                .queryParam("name", "Strawberry Jam")
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }



}