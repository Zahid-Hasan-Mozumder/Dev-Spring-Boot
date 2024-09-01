package com.zhm.spring_boot.rest.restcrud.data;

public class student {

    // field for the attrinutes

    private int student_id;
    private String firstName;
    private String lastName;
    private String gender;

    // implement the constructor

    public student(){}

    public student(int student_id, String firstName, String lastName, String gender){
        this.student_id = student_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    // implement getters and setters

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // implement toString() method

    @Override
    public String toString() {
        return "student{" +
                "student_id=" + student_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
