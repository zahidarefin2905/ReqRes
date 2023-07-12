package testCases;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;


public class Get_Post {

    @Test
    public void test_Get() {
        baseURI = "https://reqres.in/api";

        given().
                get("/users?page=2").

        then().
                statusCode(200).
                body("data[4].first_name", equalTo("George")).
                body("data.first_name", hasItems("George", "Rachel"));
    }

    @Test
    public void test_Post() {
        JSONObject request = new JSONObject();

        request.put("name", "Md");
        request.put("Job", "Associate");

        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in/api";

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(request.toJSONString()).

        when().
                post("/users").

        then().
                statusCode(201).log().all();
    }

}

