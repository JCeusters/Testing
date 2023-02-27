package tests;


import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Test;

import static org.junit.Assert.*;

import com.mashape.unirest.http.HttpResponse;

public class tests_api {
    @Test
    public void email() throws UnirestException {
        HttpResponse<String> jsonResponse
                = Unirest.get("https://reqres.in/api/users/5")
                .header("accept", "application/json")
                .asString();

        assertTrue(jsonResponse.getBody().contains("\"email\":\"charles.morris@reqres.in\""));
    }


    @Test
    public void testCreateUser() throws UnirestException {
        HttpResponse<JsonNode> jsonResponse
                = Unirest.patch("https://reqres.in/api/users/")
                .header("Content-Type", "application/json")
                .body("{\"name\":\"Jens Ceusters\", \"job\":\"Student\"}")
                .asJson();

        assertEquals("\"name\":\"Jens Ceusters\", \"job\":\"Student\"", jsonResponse.getBody());
        assertEquals(200, jsonResponse.getStatus());
    }
}
