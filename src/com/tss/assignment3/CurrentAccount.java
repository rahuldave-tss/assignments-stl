package com.tss.assignment3;

import com.tss.exceptions.MinimumBalanceException;

public class CurrentAccount extends Account{
    static final double minimumBalance=500;

    public CurrentAccount(String name, double initialBalance) {
        super(name,initialBalance);
    }

    public void deposit(double amount){
        double temp=getBalance();
        setBalance(temp+amount);
    }
    public boolean withdraw(double amount){
        double remainingBalance=getBalance()-amount;
        if(remainingBalance<minimumBalance){
            throw new MinimumBalanceException(remainingBalance);
        }

        setBalance(getBalance()-amount);
        return true;
    }
}
