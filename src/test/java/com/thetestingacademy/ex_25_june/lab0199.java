package com.thetestingacademy.ex_25_june;

import org.testng.annotations.Test;

public class lab0199 {
//same priority
    @Test(priority = 1)
    public void Get_Method_AB(){
        System.out.println("run the method AB");
    }
    @Test(priority = 1)
    public void Get_Method_AN(){
        System.out.println("run the method AN");
    }
    @Test(priority = 1)
    public void Get_Method_AC(){
        System.out.println("run the method AC");
    }
}
