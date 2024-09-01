package com.zhm.springBoot.springMVC.dataBinding.dataBinding.elements;

import java.util.List;

public class Student {

    // define fields
    private String firstName;
    private String lastName;
    private String country;
    private String favouriteLanguage;
    private List<String> favouriteOS;

    // define constructors
    public Student(){}

    // define getters and setters

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFavouriteLanguage() {
        return favouriteLanguage;
    }

    public void setFavouriteLanguage(String favouriteLanguage) {
        this.favouriteLanguage = favouriteLanguage;
    }

    public List<String> getFavouriteOS() {
        return favouriteOS;
    }

    public void setFavouriteOS(List<String> favouriteOS) {
        this.favouriteOS = favouriteOS;
    }

    // define toString() method


    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", favouriteLanguage='" + favouriteLanguage + '\'' +
                ", favouriteOS=" + favouriteOS +
                '}';
    }
}
