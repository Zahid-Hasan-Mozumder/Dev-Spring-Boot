package com.zhm.aop.aopDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // @Before("execution(public void addAccount())")
    // @Before("execution(public void updateAccount())")
    // @Before("execution(public void com.zhm.aop.aopDemo.DAO.AccountDAO.addAccount())")
    // @Before("execution(public void add*())")
    // @Before("execution(public void add*())")
    // @Before("execution(public * add*())")
    // @Before("execution(public * add*(com.zhm.aop.aopDemo.Account))")
    // @Before("execution(public * add*(com.zhm.aop.aopDemo.Account, boolean))")
    // @Before("execution(public * add*(com.zhm.aop.aopDemo.Account, ..))")
    // @Before("execution(public * add*(..))")
    // @Before("execution(public * com.zhm.aop.aopDemo.DAO.*.*(..))")
    @Before("execution(public * com.zhm.aop.aopDemo.DAO.*.*(..)) || execution(public * com.zhm.aop.aopDemo.anotherDAO.*.*(..))")
    public void loggingStuff(){
        System.out.println("Please login");
    }
}
