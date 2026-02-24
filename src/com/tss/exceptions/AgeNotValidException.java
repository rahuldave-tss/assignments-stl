package com.tss.exceptions;

public class AgeNotValidException extends Exception{
    private int age;
    public AgeNotValidException(int age) {
        this.age = age;
    }

    @Override
    public String getMessage() {
        return "Enter age greater than 18. You have entered age: "+age;
    }
}
