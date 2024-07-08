package com.thetestingacademy.ex_27_june.Jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thetestingacademy.ex_27_june.GSON.serilizisation.Booking;
import org.testng.annotations.Test;

public class lab0212_deserillization {
    @Test
    public void post_request_Jackson() throws JsonProcessingException {
        String Base_url = "https://restful-booker.herokuapp.com";
        String Base_path = "/booking";
        String jsonString = "{\n" +
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

        ObjectMapper objectMapper =new ObjectMapper();
        Booking  booking =objectMapper.readValue(jsonString, Booking.class);
        System.out.println(booking);

    }
}
