package com.zhm.aop.aopDemo.DAO;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{

    @Override
    public void addAccount() {
        System.out.println("Created a account for membership");
    }

    @Override
    public void addSillyMember() {
        System.out.println("Created a account for membership of a silly member");
    }

    @Override
    public boolean addCoolMember() {
        System.out.println("Created a account for membership of cool member");
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println("Going to sleep");
    }
}
