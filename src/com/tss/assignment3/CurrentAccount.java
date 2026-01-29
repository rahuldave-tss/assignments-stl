package com.tss.assignment3;

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
            System.out.println("Amount can't be withdrawn because you need to maintain minimum balance");
            return false;
        }
        setBalance(getBalance()-amount);
        return true;
    }
}
