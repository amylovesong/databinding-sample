package com.sun.databindingsample;

/**
 * @author sxl  (sunxiaoling@didichuxing.com)
 * @date 2018/7/22 17:00
 */
public class User {
    private final String firstName;
    private final String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String name() {
        return this.firstName + "." + this.lastName;
    }
}
