package com.zhm.aop.aopDemo;

public class Account {

    // define fields

    private String name;
    private String level;


    // define constructors

    public Account(){};

    public Account(String name, String level) {
        this.name = name;
        this.level = level;
    }

    // define getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    // define toString() method

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
