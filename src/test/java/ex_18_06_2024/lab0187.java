package ex_18_06_2024;

import org.testng.annotations.*;

public class lab0187 {
    @BeforeClass
    public void before_suit(){
        System.out.println("before suite");
    }
    @BeforeTest
    public void  before_test(){
        System.out.println("before test");
    }

    @BeforeClass
    public void before_class(){
        System.out.println("before class");
    }
    @BeforeMethod
    public void before_method(){
        System.out.println("before method");
    }
    @Test
    public void test(){
        System.out.println("test case test");
    }

    @AfterMethod
    public void after_method(){
        System.out.println("after method");
    }
    @AfterClass
    public void after_class(){
        System.out.println("after class");
    }
    @AfterTest
    public void after_test(){
        System.out.println("after test");
    }


    @AfterSuite
    public void after_sute(){
        System.out.println("after suite");
    }

}
