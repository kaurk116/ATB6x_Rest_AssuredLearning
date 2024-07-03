package com.thetestingacademy.ex_20_june.crud.Get.BDD;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
//
public class lab0189 {
@Test
    public  void getrequrestBDD(){
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/560037")
                .when().log().all().get().then().log().all().statusCode(200);

    }

}
