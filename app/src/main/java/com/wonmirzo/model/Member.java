package com.wonmirzo.model;

public class Member {

    String firstName;
    String lastName;
    Boolean isAvailable = false;

    public Member(){}

    public Member(String firstName, String lastName, Boolean isAvailable) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isAvailable = isAvailable;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}
