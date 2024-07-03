package com.thetestingacademy.ex_25_june;

import org.testng.annotations.Test;

public class lab0202 {

    //In which one method are depend on the other method
    @Test
    public void getToken(){
        System.out.println("get the token first");
    }
    @Test(dependsOnMethods = {"getToken"})
    public void getBookingId(){
        System.out.println("get booking id after get token");
    }
    @Test(dependsOnMethods = {"getToken","getBookingId"})
    public void putupdatebooking(){
        System.out.println("Update the booking");
    }
    //@Test(dependsOnMethods = {"getBookingId"}) not run bcz get boookingid we need get token
    @Test(dependsOnMethods = {"getToken"})
    public void deleteBooking(){
        System.out.println("delete the booking");
    }
}
