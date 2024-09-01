package com.zhm.spring_boot.spring_core.SpringCoreDemo.bundle;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
// @Lazy
public class cricketCoach implements Coach {

    public cricketCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout(){
        return "Run 10km consistantly. Now go run fast :)";
    }
}
