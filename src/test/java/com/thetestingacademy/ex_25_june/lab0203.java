package com.thetestingacademy.ex_25_june;

import org.testng.annotations.Test;

public class lab0203 {
// @Test(groups = {"iniit"})
    @Test(groups = {"iniit"})
    public void getToken(){
        System.out.println("get the token first");
    }
    @Test(groups = {"init"})
    public void getBookingId(){
        System.out.println("get booking id after get token");
    }
    @Test(dependsOnGroups = {"init"})
    public void putupdatebooking(){
        System.out.println("Update the booking");
    }
}
