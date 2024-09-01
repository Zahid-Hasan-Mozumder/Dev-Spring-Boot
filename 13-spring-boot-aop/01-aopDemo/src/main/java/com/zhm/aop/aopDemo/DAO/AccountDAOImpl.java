package com.zhm.aop.aopDemo.DAO;

import com.zhm.aop.aopDemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAOImpl implements AccountDAO{

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
}
