package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    // setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    // setup pointcut declaration for controller package
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage(){}

    // setup pointcut declaration for service package
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage(){}

    // setup pointcut declaration for dao package
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    // combine pointcut expressions
    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow(){}

    // add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint){

        // display method we are calling
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("In @Before: calling method : " + method);

        // display the arguments of the method
        // get the args
        Object[] args = theJoinPoint.getArgs();

        // loop through and display the args
        for(Object theArg : args){
            System.out.println("The argument is : " + theArg);
        }
    }

    // add @AfterReturning advice
    @AfterReturning(pointcut = "forAppFlow()",
                    returning = "result")
    public void afterReturning(JoinPoint theJoinPoint, Object result){

        // display method we are calling
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("In @AfterReturning: from method : " + method);

        // display returned data
        myLogger.info("The result is : " + result);
    }
}
