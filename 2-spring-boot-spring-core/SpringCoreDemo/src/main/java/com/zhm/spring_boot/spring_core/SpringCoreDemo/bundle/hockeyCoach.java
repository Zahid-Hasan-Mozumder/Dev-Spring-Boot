package com.zhm.spring_boot.spring_core.SpringCoreDemo.bundle;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
// @Lazy
public class hockeyCoach implements Coach{

    public hockeyCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout(){
        return "Do a 1km agile practicing.";
    }
}
