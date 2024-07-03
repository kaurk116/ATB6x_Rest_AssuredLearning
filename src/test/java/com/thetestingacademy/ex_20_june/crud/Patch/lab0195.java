package com.thetestingacademy.ex_20_june.crud.Patch;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class lab0195 {
    RequestSpecification rs = RestAssured.given();
    Response rp;
    ValidatableResponse vv;
    String booking_id = "booking_id";
    String baseurl = "https://restful-booker.herokuapp.com";
    String base_path = "/booking";
    String Auth_token = "e89906fe45d2f97";

    @Test
    @Description("Patch the request")
    public void Patch_Request() {
        String basepathupdate = base_path + "/1594";
        String payload = "{\n" +
                "    \"firstname\" : \"Anavia\",\n" +
                "    \"lastname\" : \"saini\"\n" +
                "}";
        // RestAssured.given();
        rs.baseUri(baseurl);
        rs.basePath(basepathupdate);
        rs.cookie(Auth_token);
        rs.contentType(ContentType.JSON);
        rs.body(payload).log().all();

        rp = rs.when().log().all().patch();

        vv = rp.then().log().all().statusCode(200);
    }
}
