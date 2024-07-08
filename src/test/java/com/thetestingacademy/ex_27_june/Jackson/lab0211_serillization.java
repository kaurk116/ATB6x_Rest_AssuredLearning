package com.thetestingacademy.ex_27_june.Jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thetestingacademy.ex_27_june.GSON.serilizisation.Booking;
import com.thetestingacademy.ex_27_june.GSON.serilizisation.BookingDates;
import org.testng.annotations.Test;

public class lab0211_serillization {
    @Test
    public void post_request_Jackson() throws JsonProcessingException {
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

        ObjectMapper objectMapper =new ObjectMapper();
        String Jsonstring = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        System.out.println(Jsonstring);
    }
}
