package com.thetestingacademy.ex_20_june.crud.Delete;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class lab0196 {


    RequestSpecification rs = RestAssured.given();
    Response rp;
    ValidatableResponse vv;
    String baseurl = "https://restful-booker.herokuapp.com";
    String booking_id = "1802";
    String base_path = "/booking";
    String Auth_token = "8219539cd602439";

    @Test
    @Description("Delete the request")
    public void Delete_Request() {
        String base_path_update = base_path+"/"+booking_id;
        // RestAssured.given();
        rs.baseUri(baseurl);
        rs.basePath(base_path_update);
        rs.cookie(Auth_token);
        rs.contentType(ContentType.JSON);
        rs.log().all();

        rp = rs.when().log().all().delete();

        vv = rp.then().log().all().statusCode(201);
    }
}
