package com.zhm.spring_boot.spring_core.SpringCoreDemo.config;

import com.zhm.spring_boot.spring_core.SpringCoreDemo.bundle.Coach;
import com.zhm.spring_boot.spring_core.SpringCoreDemo.bundle.swimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class sportConfig {

    @Bean("aquatic")
    public Coach swimCoach(){
        return new swimCoach();
    }
}
