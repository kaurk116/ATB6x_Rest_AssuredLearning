package com.thetestingacademy.ex_25_june;

import org.testng.TestRunner;
import org.testng.annotations.Test;

public class lab0198 {

    //In testNG we need to set the priority
    //setting
    //same priority
    //negative priority
    @Test(priority = 1)
    public void Get_Method_AB(){
        System.out.println("run the method AB");
    }
  @Test(priority = 0)
    public void Get_Method_AN(){
        System.out.println("run the method AN");
    }
@Test(priority = 2)
    public void Get_Method_AC(){
        System.out.println("run the method AC");
    }
}
