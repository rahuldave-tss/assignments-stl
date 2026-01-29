package com.tss.assignment3;

public abstract class Account {
    private static int newId=1;
    private static long accountCounter=100_000_000;
    private final int id;
    private final long accountNumber;
    private String customerName;
    private double balance;

    public static void setNewId(int newId) {
        Account.newId = newId;
    }

    public static void setAccountCounter(long accountCounter) {
        Account.accountCounter = accountCounter;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    Account(String customerName, double balance){
        this.id=newId;
        this.accountNumber=accountCounter;
        accountCounter+=100;
        this.customerName=customerName;
        this.balance=balance;
        newId++;
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
