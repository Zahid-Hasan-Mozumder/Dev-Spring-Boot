package com.zhm.aop.aopDemo.DAO;

import com.zhm.aop.aopDemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        // for academic purpose, simulate an exception
        if(tripWire){
            throw new RuntimeException("Get out bitch. It's an exception");
        }

        List<Account> myAccounts = new ArrayList<>();

        // create sample accounts
        Account acc1 = new Account("Zahid", "Platinum");
        Account acc2 = new Account("Jhon", "Gold");
        Account acc3 = new Account("Luca", "Silver");

        // add the sample accounts to the list
        myAccounts.add(acc1);
        myAccounts.add(acc2);
        myAccounts.add(acc3);

        return myAccounts;
    }
}
