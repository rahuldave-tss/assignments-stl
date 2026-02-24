package com.tss.sessionPractice;

import com.tss.exceptions.AgeNotValidException;

public class Voter{
    private int id;
    private String name;
    private int age;

    public Voter(int id, String name, int age) throws AgeNotValidException {
        this.id = id;
        this.name = name;
        if(age<18)throw new AgeNotValidException(age);
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws AgeNotValidException {
        if(age<18)throw new AgeNotValidException(age);
        this.age = age;
    }
}
