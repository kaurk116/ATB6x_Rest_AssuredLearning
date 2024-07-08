package com.thetestingacademy.ex_27_june.GSON.deserilization;

import com.google.gson.Gson;
import com.thetestingacademy.ex_27_june.GSON.serilizisation.Booking;
import com.thetestingacademy.ex_27_june.GSON.serilizisation.BookingDates;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class lab0210 {
    @Description("Json string change to Object string")
    @Test
    public void post_Request_Deserialization_Gson() {
        String Base_url = "https://restful-booker.herokuapp.com";
        String Base_path = "/booking";

        String jsonString ="{\n" +
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
        //Json  are change to String
        Gson gson =new Gson();
        Booking booking =gson.fromJson(jsonString,Booking.class);
        System.out.println(jsonString);
        System.out.println(booking.toString());
        System.out.println(booking.getFirstname());

    }
}
