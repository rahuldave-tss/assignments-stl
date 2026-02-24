package com.tss.assignment3;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private static int newId=1;
    private static long accountCounter=100_000_000;
    private final int id;
    private final long accountNumber;
    private String customerName;
    private double balance;
    private List<Transaction> transactionList;

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account(String customerName, double balance){
        this.id=newId;
        this.accountNumber=accountCounter;
        accountCounter+=250;
        this.customerName=customerName;
        this.balance=balance;
        newId++;
        transactionList=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public abstract void deposit(double amount);
    public abstract boolean withdraw(double amount);

}
