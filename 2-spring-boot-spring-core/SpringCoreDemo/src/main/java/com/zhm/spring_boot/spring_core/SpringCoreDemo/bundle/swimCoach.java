package com.zhm.spring_boot.spring_core.SpringCoreDemo.bundle;

public class swimCoach implements Coach{

    public swimCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim a 1000 meter for the warm up.";
    }


    public String extra() {
        return "Swim in fish style for 500 meter.";
    }
}
