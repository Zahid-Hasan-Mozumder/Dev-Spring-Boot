package com.zhm.spring_boot.spring_core.SpringCoreDemo.rest;

import com.zhm.spring_boot.spring_core.SpringCoreDemo.bundle.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    /*

    private Coach myCoach;

    // Constructor Injection
    @Autowired
    public Controller(Coach aCoach){
        myCoach = aCoach;
    }

    // Setter Injection
    @Autowired
    public void setDailyWorkout(Coach aCoach){
        myCoach = aCoach;
    }

    // Setter Injection -> with different function name avoiding the traditional name like setValue etc
    @Autowired
    public void okay(Coach aCoach){
        myCoach = aCoach;
    }


    // Field Injection -> This injection has some problem that it makes the unit testing
    //                    harder and it is not recommended by the spring.io development team.
    @Autowired
    private Coach myCoach;
    // No need for constructor or setter

    */

    private Coach myCoach;
    //private Coach anotherCoach;

    @Autowired
    public Controller(@Qualifier("aquatic") Coach firstCoach){
                      //, @Qualifier("footballCoach") Coach secondCoach){
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = firstCoach;
        //anotherCoach = secondCoach;
    }


    @GetMapping("/dailyWorkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    /*
    // Check for singleton or prototype component
    @GetMapping("/check")
    public void checkBeanScope(){
        if(myCoach == anotherCoach){
            System.out.println("Both instance are same");
        }
        else{
            System.out.println("Instances are not same");
        }
    }
    */
}
