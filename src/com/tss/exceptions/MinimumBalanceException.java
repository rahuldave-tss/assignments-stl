package com.tss.exceptions;

public class MinimumBalanceException extends RuntimeException{
    private double balance;
    public MinimumBalanceException(double balance) {
        this.balance = balance;
    }

    @Override
    public String getMessage() {
        return "You need to maintain 500Rs. as Minimum Balance and this action violates it !! If you withdraw " +
                "this amount , your remaining balance would be :"+balance;
    }
}
