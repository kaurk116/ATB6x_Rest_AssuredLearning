package com.thetestingacademy.ex_27_june.GSON.serilizisation;
import com.google.gson.Gson;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class lab0208 {

    @Description("Object change to Json string")
        @Test
        public void Post_Request_serialization_gson() {
            String Base_url = "https://restful-booker.herokuapp.com";
            String Base_path = "/booking";

        Booking booking =new Booking();
        booking.setFirstname("James");
        booking.setLastname("Brown");
        booking.setTotalprice(200);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

            System.out.println(booking.toString());
        //objects  are change to Json string
            Gson gson =new Gson();
            String jsonStringPayload = gson.toJson(booking);
            System.out.println(jsonStringPayload);


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
