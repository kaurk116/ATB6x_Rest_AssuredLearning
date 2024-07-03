package com.thetestingacademy.ex_20_june.crud.Get.nonBDD;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class lab0190 {
@Test
    public  void getrequrestnonBDD(){
        RequestSpecification rs =RestAssured.given();
    rs.baseUri("https://api.zippopotam.us");
    rs.basePath("/IN/560037");
    rs.when().get().then().log().all().statusCode(200);


    }

}
