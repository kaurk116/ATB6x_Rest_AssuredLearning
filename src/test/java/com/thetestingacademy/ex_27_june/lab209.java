package com.thetestingacademy.ex_27_june;

import com.google.gson.Gson;
import com.thetestingacademy.ex_27_june.GSON.serilizisation.Booking;
import com.thetestingacademy.ex_27_june.GSON.serilizisation.BookingDates;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class lab209 {
       //create the multiple booking
    @Description("Post_Request two or more|Object change to Json string")
    @Test

    public void Post_Request_serialization_Gson() {
        String Base_url = "https://restful-booker.herokuapp.com";
        String Base_path = "/booking";

        Booking booking =new Booking();
        booking.setFirstname("karam");
        booking.setLastname("kaur");
        booking.setTotalprice(100);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking.toString());

        Booking booking1 =new Booking();
        booking1.setFirstname("Anna");
        booking1.setLastname("saini");
        booking1.setTotalprice(-1);
        booking1.setDepositpaid(true);

        BookingDates bookingdates1 = new BookingDates();
        bookingdates1.setCheckin("2024-02-01");
        bookingdates1.setCheckout("2024-02-01");
        booking1.setBookingdates(bookingdates1);
        booking1.setAdditionalneeds("Breakfast");

        System.out.println(booking.toString());

        Gson gson =new Gson();
        String jsonStringPayload = gson.toJson(booking);

        String jsonStringPayload1 = gson.toJson(booking1);
        System.out.println(jsonStringPayload);
        System.out.println(jsonStringPayload1);


           /* RequestSpecification rs = RestAssured.given();
            rs.baseUri(Base_url);
            rs.basePath(Base_path);
            rs.contentType(ContentType.JSON);
            rs.body(booking);

            Response response = rs.when().post();
            String responseString= response.toString();
            System.out.println(responseString);

            ValidatableResponse ValidatableResponse = response.then();
            ValidatableResponse.statusCode(200);*/

    }
}

