package com.thetestingacademy.ex_27_june;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class lab0207 {

    //"{\n" +
    //                "    \"firstname\" : \"karamjeet\",\n" +
    //                "    \"lastname\" : \"kaur\",\n" +
    //                "    \"totalprice\" : 5000,\n" +
    //                "    \"depositpaid\" : true,\n" +
    //                "    \"bookingdates\" : {\n" +
    //                "        \"checkin\" : \"2024-01-01\",\n" +
    //                "        \"checkout\" : \"2024-02-01\"\n" +
    //                "    },\n" +
    //                "    \"additionalneeds\" : \"Breakfast, lunch\"\n" +
    //                "}";
    @Test
    public void testPOSTReq(){
        Map<String,Object> jsonBodyUsingMap =new LinkedHashMap<>();
        Faker faker =new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        jsonBodyUsingMap.put("firstname",firstName);
        jsonBodyUsingMap.put("lastName",lastName);
        jsonBodyUsingMap.put("totalprice",faker.random().nextInt(1000));
        jsonBodyUsingMap.put("depositpaid",faker.random().nextBoolean());

        Map<String,Object> Json_bookingdates =new LinkedHashMap<>();
        Json_bookingdates.put("checkin","2024-01-01");
        Json_bookingdates.put("checkout","2024-02-01");

        jsonBodyUsingMap.put("bookingdates",Json_bookingdates);
        jsonBodyUsingMap.put("additionalneeds","breakfast");

        System.out.println(Json_bookingdates);
        System.out.println(Json_bookingdates);

        RequestSpecification r = RestAssured
                .given();

        Response response;

        ValidatableResponse validatableResponse;

        String BASE_URL = "https://restful-booker.herokuapp.com";
        String BASE_PATH = "/booking";
        r.baseUri(BASE_URL);
        r.basePath(BASE_PATH);
        r.contentType(ContentType.JSON).log().all();
        r.body(jsonBodyUsingMap);

        response = r.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);


        validatableResponse = response.then();
        validatableResponse.statusCode(200);

    }
}
