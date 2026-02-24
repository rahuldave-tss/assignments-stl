package com.tss.assignment9;

public class Account {
    private static int newId=1;
    private int id;
    private String name;
    private double balance;

    Account(){}
    Account(String name,double balance){
        this.id=newId++;
        this.name=name;
        this.balance=balance;
    }

    public static int getNewId() {
        return newId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
