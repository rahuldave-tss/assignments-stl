package com.tss.exceptions;

public class NegativeAmountException extends RuntimeException{
    @Override
    public String getMessage() {
        return "You Entered Negative Amount !! , Please Enter it again";
    }

}
