package com.thetestingacademy.ex_25_june;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class lab0200 {
    @Description("run in alura report")
    @Test(priority = -1)
    public void Get_Method_AB(){
        System.out.println("run the method AB");
    }
    @Test(priority = 0)
    public void Get_Method_AN(){
        System.out.println("run the method AN");
    }
    @Test(priority = 1)
    public void Get_Method_AC(){
        System.out.println("run the method AC");
    }
}
