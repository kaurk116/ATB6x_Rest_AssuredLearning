package com.thetestingacademy.ex_25_june;

import org.testng.annotations.Test;

public class lab0201 {
    //grouping of test cases
    //100 total
    //1 to 20 in p1
        @Test(groups = "sanity")
        public void SanityRun(){
            System.out.println("run the method SanityRun");
        }
        @Test(groups ="reg")
        public void RegrationRun(){
            System.out.println("run the method RegrationRun");
        }
        @Test(groups = "smoke")
        public void SmokeRun(){
            System.out.println("run the method SmokeRun");
        }
}
