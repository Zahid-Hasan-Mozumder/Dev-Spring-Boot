package com.zhm.springboot.personalProject.personalProject.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull(message = "is required")
    @Min(value = 203002001, message = "Id must be greater than or equal to 203002001")
    @Max(value = 203002999, message = "Id must be less than or equal to 203002999")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message = "is required")
    private String lastName;

    @Column(name = "email")
    @NotNull(message = "is required")
    @Email(message = "please insert valid format of email")
    private String email;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "major")
    private List<String> major;

    @Column(name = "semester")
    private Integer semester;

    @Column(name = "section")
    @Pattern(regexp = "^[A-Z 0-9]{5}", message = "Must be in 5 character")
    private String section;


    // define constructors

    public Student(){}


    // define getters and setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<String> getMajor() {
        return major;
    }

    public void setMajor(List<String> major) {
        this.major = major;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    // define toString() method

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", nationality='" + nationality + '\'' +
                ", major=" + major +
                ", semester=" + semester +
                ", section='" + section + '\'' +
                '}';
    }
}
