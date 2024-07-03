package com.thetestingacademy.ex_25_june;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class lab0204 {

    //String value;
    @Parameters("browser")
    @Test
    public void test_diff_browser(String value){
        System.out.println("browser is " +value);
        switch (value) {
            case "firefox":
            System.out.println("start the firefox");
            case "chrome":
                System.out.println("start the chrome");
            case "default":
                System.out.println("not known");


        }
    }
}
