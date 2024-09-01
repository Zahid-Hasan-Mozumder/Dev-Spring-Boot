package com.zhm.aop.aopDemo.DAO;

import com.zhm.aop.aopDemo.Account;

public interface AccountDAO {

    public void addAccount();

    public void addAccount(Account theAccount);

    public void addAccount(Account theAccount, boolean flag);
}
