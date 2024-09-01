package com.zhm.aop.aopDemo.anotherDAO;

import org.springframework.stereotype.Repository;

@Repository
public class TestDAOImpl implements TestDAO{

    @Override
    public void testAccount() {
        System.out.println("Created a test account");
    }
}
