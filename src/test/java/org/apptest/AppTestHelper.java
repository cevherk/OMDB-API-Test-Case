package org.apptest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.not;

public class AppTestHelper {

    String baseURI = System.getProperty("baseURI","http://www.omdbapi.com/");

    public String getIdFromMovie(String apiKey, String searchWord, String movieTitle) {
        RestAssured.baseURI = baseURI;
        String id = null;
        try {
            Response response = getResponseFromEndPoint(apiKey,searchWord);

            JsonPath path = response.jsonPath();
            List<MovieDTO> data = path.getList("Search", MovieDTO.class);

            for (MovieDTO singleObject : data) {
                if (singleObject.getTitle().equals(movieTitle)) {
                    id = singleObject.getImdbID();
                    break;
                }
            }
            return id;
        }catch (Exception ex){
            System.out.println("HATA! " + ex.getMessage());
            return null;
        }
    }

    public void searchByID(String apiKey, String id) {
        try {
            given()
                    .param("apikey", apiKey)
                    .param("i",id)
                    .when()
                    .get()
                    .then()
                    .log()
                    .all()
                    .statusCode(200)
                    .body("Title", not(emptyOrNullString()))
                    .body("Year", not(emptyOrNullString()))
                    .body("Released", not(emptyOrNullString()));
        }catch (Exception ex){
            System.out.println("HATA! "+ex.getMessage());
        }
    }

    private Response getResponseFromEndPoint(String apiKey, String searchWord) {
        try {
            return given()
                    .param("apikey", apiKey)
                    .param("s", searchWord)
                    .when()
                    .get()
                    .then()
                    .log()
                    .all()
                    .contentType(ContentType.JSON)
                    .statusCode(200)
                    .and()
                    .body("Search.Title",not(emptyOrNullString()))
                    .body("Search.Year",not(emptyOrNullString()))
                    .extract()
                    .response();
        }catch (Exception ex){
            System.out.println("HATA! "+ex.getMessage());
            return null;
        }
    }
}