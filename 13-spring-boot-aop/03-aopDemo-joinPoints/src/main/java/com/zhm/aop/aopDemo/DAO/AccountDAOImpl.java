package com.zhm.aop.aopDemo.DAO;

import com.zhm.aop.aopDemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAOImpl implements AccountDAO{

    private String name;
    private String serviceCode;

    @Override
    public void addAccount() {
        System.out.println("Created a new account");
    }

    @Override
    public void addAccount(Account theAccount) {
        System.out.println("Created a new account with single parameter");
    }

    @Override
    public void addAccount(Account theAccount, boolean flag) {
        System.out.println("Created a new account with multiple parameter");
    }

    public String getName() {
        System.out.println( "In getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println( "In setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println( "In getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println( "In setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
