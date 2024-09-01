package com.zhm.spring_boot.spring_core.SpringCoreDemo.bundle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// @Lazy
// @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class footballCoach implements Coach{

    public footballCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    /*
    @PostConstruct
    public void init(){
        System.out.println("In initialization: " + getClass().getSimpleName());
    }

    @PreDestroy
    public void over(){
        System.out.println("In ending process: " + getClass().getSimpleName());
    }
    */

    @Override
    public String getDailyWorkout(){
        return "Try to goal 10 times on 15 tries.";
    }

}
