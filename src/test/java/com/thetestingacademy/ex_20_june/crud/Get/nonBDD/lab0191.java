package com.thetestingacademy.ex_20_june.crud.Get.nonBDD;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class lab0191 {
    @Test

    //positive testcase
    public void Get_request_nonBDD(){
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/1594").log().all();
        r.when();
        r.get().then().log().all().statusCode(200);
    }
    @Test
//negitive testcase
    public void Get_request_nonBDD2(){
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/-1").log().all();
        r.when();
        r.get().then().log().all().statusCode(404);
    }
}
