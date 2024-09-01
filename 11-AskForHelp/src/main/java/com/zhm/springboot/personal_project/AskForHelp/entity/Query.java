package com.zhm.springboot.personal_project.AskForHelp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "queries")
public class Query {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String name;

    @Column(name = "email")
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String email;

    @Column(name = "query")
    private String query;

    @Column(name = "time")
    private String time;

    @Column(name = "contact_no")
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String contactNo;

    @Column(name = "offering_amount")
    @NotNull(message = "is required")
    @Min(value = 100, message = "Minimum amount is 100")
    private double offeringAmount;

    @Column(name = "status")
    private String status;



    // define constructors
    public Query(){}



    // define getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public double getOfferingAmount() {
        return offeringAmount;
    }

    public void setOfferingAmount(double offeringAmount) {
        this.offeringAmount = offeringAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    // define toString() method

    @Override
    public String toString() {
        return "Query{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", query='" + query + '\'' +
                ", time='" + time + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", offeringAmount=" + offeringAmount +
                ", status=" + status +
                '}';
    }
}
