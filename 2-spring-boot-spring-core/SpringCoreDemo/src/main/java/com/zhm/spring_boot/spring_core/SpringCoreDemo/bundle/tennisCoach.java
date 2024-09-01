package com.zhm.spring_boot.spring_core.SpringCoreDemo.bundle;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
// @Lazy
public class tennisCoach implements Coach{

    public tennisCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout(){
        return "Play tennis alone with a practice wall for 30 minutes.";
    }
}
