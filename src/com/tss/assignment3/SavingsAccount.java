package com.tss.assignment3;

public class SavingsAccount extends Account{
    static final double offerRate=8.0;

    public SavingsAccount(String name, double initialBalance) {
        super(name,initialBalance);
    }

    public void deposit(double amount){
        if(amount>=50000){
            double benefit=(amount*offerRate)/100;
            amount+=benefit;
        }
        setBalance(amount+getBalance());
    }
    public boolean withdraw(double amount){
        if(getBalance()-amount<0){
            System.out.println("Insufficient Balance");
            return false;
        }
        setBalance(getBalance()-amount);
        return true;
    }

}
