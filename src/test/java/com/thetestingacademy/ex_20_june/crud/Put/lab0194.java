package com.thetestingacademy.ex_20_june.crud.Put;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class lab0194 {

    RequestSpecification rs =RestAssured.given();
    Response rp;
    ValidatableResponse vv;
    String booking_id="booking_id";
    String baseurl ="https://restful-booker.herokuapp.com";
    String base_path="/booking";
    String Auth_token="e89906fe45d2f97";

    @Test
    @Description("Put the request")
    public void Put_Request(){
        String basepathupdate =base_path+"/1594";
        String payload ="{\n" +
                "    \"firstname\" : \"karamjeet\",\n" +
                "    \"lastname\" : \"kaur\",\n" +
                "    \"totalprice\" : 5000,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-02-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast, lunch\"\n" +
                "}";
       // RestAssured.given();
        rs.baseUri(baseurl);
        rs.basePath(basepathupdate);
        rs.cookie(Auth_token);
        rs.contentType(ContentType.JSON);
        rs.body(payload).log().all();

       rp= rs.when().log().all().put();

       vv = rp.then().log().all().statusCode(200);






    }
}
