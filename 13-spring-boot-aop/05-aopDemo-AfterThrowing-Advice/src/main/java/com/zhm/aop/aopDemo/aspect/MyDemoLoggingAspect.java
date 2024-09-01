package com.zhm.aop.aopDemo.aspect;

import com.zhm.aop.aopDemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;


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
    public void loggingStuff(JoinPoint theJoinPoint){
        System.out.println("Please login");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method : " + methodSignature);

        // display method arguments

        // get args
        Object[] args = theJoinPoint.getArgs();

        // loop through the args
        for(Object tmpArg : args){
            System.out.println(tmpArg);

            if(tmpArg instanceof Account){
                Account theAccount = (Account) tmpArg;

                System.out.println("Account name : " + theAccount.getName());
                System.out.println("Account level : " + theAccount.getLevel());
            }
        }
    }

    @AfterReturning(pointcut = "execution(* com.zhm.aop.aopDemo.DAO.AccountDAO.findAccounts(..))",
                    returning = "result")
    public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result){

        // print out which method we are coming from
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("Coming from the method : " + method);

        // modifying the returned result
        for(Account tmpAccount : result){
            String theName = tmpAccount.getName().toUpperCase();
            tmpAccount.setName(theName);
        }

        // print out the result of the method call
        System.out.println("The result from the previous method is: ");
        System.out.println(result);

    }

    @AfterThrowing(pointcut = "execution(* com.zhm.aop.aopDemo.DAO.AccountDAO.findAccounts(..))",
                  throwing = "exception")
    public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable exception){

        // print out from which method we are coming from
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("Coming from the method : " + method);

        // log the exception
        System.out.println("The exception from the previous method is: " + exception);
    }
}
