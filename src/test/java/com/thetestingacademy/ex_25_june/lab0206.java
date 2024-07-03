package com.thetestingacademy.ex_25_june;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class lab0206 {

    @Test
    public void tesfaker() {
        Faker faker = new Faker();
        String username = faker.name().username();
        String phonenumber = faker.phoneNumber().phoneNumber();
        System.out.println(username);
        System.out.println(phonenumber);
    }

}
