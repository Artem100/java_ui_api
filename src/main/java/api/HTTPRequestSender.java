package api;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import api.json.Pojo;

import static io.restassured.RestAssured.given;


// METHODS

public class HTTPRequestSender {

    public static ValidatableResponse get(String path) {
        return given().
                contentType(ContentType.JSON).
                //header("Authorization", "Authorization=" + Authorization.coockieLogin).
                when().
                get(path).then();
    }

    public static ValidatableResponse post(String path, Pojo body) {
        return given().
                contentType(ContentType.JSON).
                //header().
                //header("Authorization", Authorization.coockieLogin).
                when().
                body(body).
                post(path).
                then().log().all();
    }

    public static ValidatableResponse put(String path,  Pojo body){

        return given().
                contentType(ContentType.JSON).
                // header("Authorization", "Authorization=" + Authorization.coockieLogin2).
                body(body).
                when().
                put(path).
                then();

    }

    public static ValidatableResponse delete(String path) {
        return given().
                contentType(ContentType.JSON).
                //header("Authorization: ", Authorization.coockieLogin).
                when().
                delete(path).
                then();
    }
}
