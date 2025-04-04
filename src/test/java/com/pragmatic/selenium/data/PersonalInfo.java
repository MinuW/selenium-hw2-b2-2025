package com.pragmatic.selenium.data;

import net.datafaker.Faker;

public class PersonalInfo {
    private static String firstName;
    private static String lastName;
    private static String postalCode;

    public PersonalInfo() {
        Faker faker = new Faker();
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        postalCode = faker.address().postcode();

    }

    public static String getFirstName() {
        return firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static String getPostalCode() {
        return postalCode;
    }
}
