package com.example.utils;

public class UserUtil {
    private UserUtil() {
    }
    public static String convertToFullName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }
}
