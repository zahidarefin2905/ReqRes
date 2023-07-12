package testCases;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class Put_Patch_Delete {

    @Test
    public void test_Put() {
        JSONObject request = new JSONObject();

        request.put("name", "Md");
        request.put("Job", "Associate");

        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in";

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).

        when().
                put("/api/users/2").

        then().
                statusCode(200).
                log().all();
    }

    @Test
    public void test_Patch() {
        JSONObject request = new JSONObject();

        request.put("name", "Md");
        request.put("Job", "Associate");

        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in";

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).

        when().
                patch("/api/users/2").

        then().
                statusCode(200).
                log().all();
    }

    @Test
    public void test_Delete() {
        baseURI = "https://reqres.in";

        when().
                delete("/api/users/2").

        then().
                statusCode(204).
                log().all();
    }
}
