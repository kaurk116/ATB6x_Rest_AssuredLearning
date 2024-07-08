package com.thetestingacademy.ex_22_june.Full_Testcase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.AbstractBigDecimalAssert;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class lab0197 {

    String token;
    Integer bookingId;
    RequestSpecification requestSpecification = RestAssured.given();
    Response response;
    ValidatableResponse validatableResponse;

    @BeforeTest
    @Test
    public void getAToken() {
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("auth");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);

        response = requestSpecification.post();

        validatableResponse = response.then();
        validatableResponse.statusCode(200);

        //Extract the token from this

        token = response.then().log().all().extract().path("token");
        Assert.assertNotNull(token);
    }

    @BeforeTest
    @Test
    public void getBookingId() {
        String payload = "{\n" +
                "    \"firstname\" : \"Anavia\",\n" +
                "    \"lastname\" : \"saini\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);

        response = requestSpecification.when().post();

        ValidatableResponse validatableResponse = response.then();
        String responseString = response.asString();
        System.out.println(responseString);

        validatableResponse.statusCode(200);

        bookingId = response.then().log().all().extract().path("bookingid");
        String firstName = response.then().log().all().extract().path("booking.firstname");
        System.out.println(firstName);
        System.out.println(bookingId);
        Assert.assertNotNull(bookingId);
        validatableResponse.body("booking.firstname", Matchers.equalToObject("Anavia"));
    }

    @Test
    public void testPUTRequestPositive() {

        System.out.println(" - Test Case PUT Request ");
        String payload = "{\n" +
                "    \"firstname\" : \"Anavia\",\n" +
                "    \"lastname\" : \"saini\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking/" + bookingId);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);

        requestSpecification.body(payload).log().all();

        response = requestSpecification.when().put();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        String firstnameresponse = response.then().log().all().extract().path("firstname");
        System.out.println(firstnameresponse);
        Assert.assertEquals(firstnameresponse, "Anavia");


        //# way to get the responce

        //1. RA -responce body matcher

        validatableResponse.body("firstname", Matchers.equalToObject("Anavia"));
        validatableResponse.body("lastname", Matchers.equalToObject("saini"));
        //2.TestNG Asserts-
        //TestNG Assert.assertEquals(firstnameresponse,"Anavia");
        String firstNameResponse = response.then().log().all().extract().path("firstname");
        Assert.assertEquals(firstNameResponse, "Anavia");
        System.out.println(firstNameResponse);

        //extract dates
        String checkoutdates = response.then().extract().path("bookingdates.checkout");
        Assert.assertEquals(checkoutdates, "2019-01-01");
        System.out.println(checkoutdates);

        //to get the all keys
        String fullResponseJSONString = response.asString();
        System.out.println(fullResponseJSONString);

        //3.TestNG Assertion with Json Path Lib
        String onebyoneresponse = response.asString();
        JsonPath jsonPath = new JsonPath(onebyoneresponse);
        String firstname = jsonPath.getString("firstname");
        Integer totalprice = jsonPath.getInt("totalprice");
        String checkindates = jsonPath.getString("bookingdates.checkin");
        //System.out.println(firstname);

        Assert.assertEquals(firstname, "Anavia");
        Assert.assertEquals(totalprice, 111);
        Assert.assertEquals(checkindates, "2018-01-01");
        System.out.println(firstname);
        System.out.println(totalprice);
        System.out.println(checkindates);

        // 4. AssertJ Matching

        assertThat(firstname)
                .isEqualTo("Anavia")
                .isNotBlank().isNotEmpty();

        assertThat(totalprice).isPositive().isNotZero();
    }
}