package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WeatherApiTest {
    private String url = "https://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=8a15b218e00277cb399088eb39cfad1e";

    @Test
    public void apiResponseTest() {
        System.out.println("API TESTING");
        final Response response = RestAssured.get(String.valueOf(url));
        response.then().statusCode(HttpStatus.SC_OK);
        RestAssured.given()
                .relaxedHTTPSValidation();
        System.out.println("GET Response\n" + response.asString());
    }

    @Test
    public void locationResponseTest() {
        final ValidatableResponse response =   RestAssured.given()
                .relaxedHTTPSValidation()
                .param("country", "GB")
                .param("name", "London")
                .when()
                .get(url)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON);

        Assert.assertNotNull("id");
        System.out.println("GET Response\n" + response.extract().body());
    }

    @Test
    public void weatherNotNullTest() {
        RestAssured.given()
                .relaxedHTTPSValidation()
                .when()
                .get(url)
                .then()
                .body("main", Matchers.notNullValue())
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON);
    }
}
