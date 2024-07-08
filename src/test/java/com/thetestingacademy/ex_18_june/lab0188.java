package com.thetestingacademy.ex_18_june;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class lab0188 {
    @Deprecated
    @Test
    public void Soft_Assertion() {
        // Soft Assertion
        SoftAssert s = new SoftAssert();
        s.assertEquals("karam", "karam", "not equal");
        System.out.println("end of the program");
        s.assertAll();

    }
    @Test
    @Description
        public void Hard_Assertion(){
            //Hard Assertion
            Assert.assertEquals("karamjeet", "karamjeet", "not equal to");
            System.out.println("end of program2");
        }
    }
