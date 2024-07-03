package ex_18_06_2024;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class lab0185 {
@Description("test the lab00185 -1")
@Test
        public void getRequest() {
            RestAssured
                    .given()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/ping")
                    .when().get().then().statusCode(201);

        }

        @Description("test the case lab00185 -2")
@Test
    public void getRequest2() {
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
                .when().get().then().statusCode(201);

    }

    }

