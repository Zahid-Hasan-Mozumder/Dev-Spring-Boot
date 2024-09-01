package com.zhm.aop.aopDemo.DAO;

import com.zhm.aop.aopDemo.Account;

public interface AccountDAO {

    public void addAccount();

    public void addAccount(Account theAccount);

    public void addAccount(Account theAccount, boolean flag);

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);
}
