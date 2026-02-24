package com.tss.assignment9;

import java.util.ArrayList;
import java.util.List;

public class AccountMainn {
    public static void main(String[] args) {
        List<Account> accounts=new ArrayList<>();

        accounts.add(new Account("Rahul",5000));
        accounts.add(new Account("Smit Patel",4000));
        accounts.add(new Account("Neel",2000));
        accounts.add(new Account("Tanmay Jotangia",10000));

        System.out.println("Account Details that have Minimum Balance");
        accounts.stream().
                sorted((Account a,Account b)-> (int) (a.getBalance()-b.getBalance())).
                limit(1).
                forEach(System.out::println);


        System.out.println();
        System.out.println("Account Details that have Maximum Balance");
        accounts.stream().
                sorted((Account a,Account b)-> (int) (b.getBalance()-a.getBalance())).
                limit(1).
                forEach(System.out::println);


        System.out.println();
        System.out.println("Show names of account holders that has >6 characters");
        accounts.stream().
                map(Account::getName).
                filter(name -> name.length()>6).
                forEach(System.out::println);


        System.out.println();
        System.out.println("Total balance of All accounts");
        double totalBalance=
                accounts.stream().
                        map(Account::getBalance).
                        reduce(0.0,(( a, b)->a+b));
        System.out.println(totalBalance);



    }
}
