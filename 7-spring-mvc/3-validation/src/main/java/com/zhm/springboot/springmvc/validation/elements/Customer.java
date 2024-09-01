package com.zhm.springboot.springmvc.validation.elements;

import com.zhm.springboot.springmvc.validation.customAnnotation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    // define fields
    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;

    @NotNull(message = "is required")
    @Min(value = 0, message = "The rating should be greater than or equal to 0")
    @Max(value = 5, message = "The rating should be less than or equal to 5")
    private Integer providedRating;

    @NotNull(message = "is required")
    @Pattern(regexp = "^[a-z A-Z 0-9]{2,5}", message = "Only 2 to 5 character or digit")
    private String postalCode;

    @NotNull(message = "is required")
    @CourseCode(value = "BAN", message = "Must start with CSE")
    private String courseCode;

    // define constructors
    public Customer(){}

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

    public Integer getProvidedRating() {
        return providedRating;
    }

    public void setProvidedRating(Integer providedRating) {
        this.providedRating = providedRating;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
