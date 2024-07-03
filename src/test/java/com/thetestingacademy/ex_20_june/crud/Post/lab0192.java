package com.thetestingacademy.ex_20_june.crud.Post;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class lab0192 {
    @Description("BDD")
    @Test
    public void Post_Request_BDD(){
        String Base_url ="https://restful-booker.herokuapp.com";
        String Base_path="/booking";
        String Payload ="{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        RestAssured
                .given().baseUri(Base_url).basePath(Base_path)
                .contentType(ContentType.JSON).log().all().body(Payload)
                .when().post().then().log().all().statusCode(200);
    }
}
