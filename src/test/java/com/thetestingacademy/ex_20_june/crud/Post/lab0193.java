package com.thetestingacademy.ex_20_june.crud.Post;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class lab0193 {
 @Description("non Bdd")
    @Test
    public void Post_Request_NonBdd() {
        String Base_url = "https://restful-booker.herokuapp.com";
        String Base_path = "/booking";
        String Payload = "{\n" +
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
        RequestSpecification rs = RestAssured.given();
        rs.baseUri(Base_url);
        rs.basePath(Base_path);
        rs.contentType(ContentType.JSON);
        rs.body(Payload);

        Response response = rs.when().post();
        String responseString= response.toString();
        System.out.println(responseString);

        ValidatableResponse ValidatableResponse = response.then();
        ValidatableResponse.statusCode(200);

    }
}
