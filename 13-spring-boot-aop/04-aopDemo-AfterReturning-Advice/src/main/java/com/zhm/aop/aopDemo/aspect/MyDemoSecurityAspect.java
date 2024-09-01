package com.zhm.aop.aopDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoSecurityAspect {
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
    public void securityStuff(){
        System.out.println("Please do biometric verification");
    }
}
