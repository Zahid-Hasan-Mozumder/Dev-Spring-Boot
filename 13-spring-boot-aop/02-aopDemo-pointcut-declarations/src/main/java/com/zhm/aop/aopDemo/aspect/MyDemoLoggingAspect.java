package com.zhm.aop.aopDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
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
    // @Before("execution(public * com.zhm.aop.aopDemo.DAO.*.*(..)) || execution(public * com.zhm.aop.aopDemo.anotherDAO.*.*(..))")

    /*
    @Pointcut("execution(public * com.zhm.aop.aopDemo.DAO.*.*(..))")
    public void declaration(){}
    */

//    // create a pointcut for all the methods
//    @Pointcut("execution(public * com.zhm.aop.aopDemo.DAO.*.*(..))")
//    public void all(){}
//
//    // create a pointcut for all the getter methods
//    @Pointcut("execution(public * com.zhm.aop.aopDemo.DAO.*.get*(..))")
//    public void getter(){}
//
//    // create a pointcut for all the setter methods
//    @Pointcut("execution(public * com.zhm.aop.aopDemo.DAO.*.set*(..))")
//    public void setter(){}
//
//    // create a pointcut to include all methods but exclude getters and setters method
//    @Pointcut("all() && !(getter() || setter())")
//    public void declaration(){}


    @Before("com.zhm.aop.aopDemo.aspect.AOPExpressions.declaration()")
    public void loggingStuff(){
        System.out.println("Please login");
    }
}
