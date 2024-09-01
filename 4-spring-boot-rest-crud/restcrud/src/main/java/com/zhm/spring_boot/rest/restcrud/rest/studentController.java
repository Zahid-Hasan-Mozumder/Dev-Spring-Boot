package com.zhm.spring_boot.rest.restcrud.rest;

import com.zhm.spring_boot.rest.restcrud.data.student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class studentController {

    // define field for attributes
    private List<student> theStudents;

    // load the data at the time of running -- only once
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();

        theStudents.add(new student(1, "Zahid", "Hasan", "Male"));
        theStudents.add(new student(2, "Nusrat", "Jahan", "Female"));
        theStudents.add(new student(3, "Abu Saleh", "Nayeem", "Male"));
        theStudents.add(new student(4, "Rabiul", "Hasan", "Male"));
    }

    @GetMapping("/students")
    public List<student> getStudents(){
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public student getStudent(@PathVariable int studentId){

        if((studentId >= theStudents.size()) || (studentId < 0)){
            throw new studentNotFoundException("Student id - " + studentId + " is not found");
        }
        return theStudents.get(studentId);
    }

}
