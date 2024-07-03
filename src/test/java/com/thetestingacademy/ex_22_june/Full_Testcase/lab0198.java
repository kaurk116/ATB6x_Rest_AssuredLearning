package com.thetestingacademy.ex_22_june.Full_Testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class lab0198 {
    @BeforeTest
    public void getAToken(){
        System.out.println(1);
    }
    @BeforeTest
    public  void getBookingID(){
        System.out.println(2);
    }
    @Test
    public void test(){
        System.out.println(3);
    }
}
