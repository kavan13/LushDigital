package com.lushdigital.productsinfo;

import com.lushdigital.ProductPojo;
import com.lushdigital.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductsTest extends TestBase {
    @Test
    public void getAllProductsInfo() {
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
    public void createProductwithPost() {
        ProductPojo productPojo = new ProductPojo();
        productPojo.setName("Raspb");
        productPojo.setAvailable(3);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(productPojo)
                .when()
                .post();
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void createProductwithPost1() {
        ProductPojo productPojo = new ProductPojo();
        productPojo.setName("Blueberry");
        productPojo.setAvailable(150);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(productPojo)
                .when()
                .post();
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void createProductwithPut() {
        ProductPojo productPojo = new ProductPojo();
        productPojo.setName("Apple");
        productPojo.setAvailable(10);

        Response response = given()
                .basePath("/products")
                .header("Content-Type", "application/json")
                .pathParam("id", 11)
                .body(productPojo)
                .when()
                .put("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void createProductwithPatch() {
        ProductPojo productPojo = new ProductPojo();
        productPojo.setName("orange");

        Response response = given()
             //   .basePath("/products")
                .header("Content-Type", "application/json")
                .pathParam("id", 7)

                .body(productPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(405);
        response.prettyPrint();
    }
    @Test
    public void deleteProduct() {
        Response response = given()
                .pathParam("id", 3)
                .header("Content-Type", "application/json")
                .when()
                .delete("/{id}");
        response.then().statusCode(200);
    }
}
