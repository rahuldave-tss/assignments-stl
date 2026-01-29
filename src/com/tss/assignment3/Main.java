package com.tss.assignment3;

import java.util.Scanner;


public class Main {
    static Scanner scanner=new Scanner(System.in);
    static final int MAX_ACCOUNTS=10;
    static Account[] accounts=new Account[MAX_ACCOUNTS];
    static int accountIndex=0;

    public static void main(String[] args) {

        while(true){
            displayMenu();
            int choice= validateInt();
            switch (choice){
                case 1:{
                    createAccount();
                    break;
                }
                case 2:{
                    depositMoney();
                    break;
                }
                case 3:{
                    withdrawMoney();
                    break;
                }
                case 4:{
                    showBalance();
                    break;
                }
                case 5:{
                    transferMoney();
                    break;
                }
                case 6:{
                    System.out.println("Have a Good Day!!");
                    return;
                }
                default:{
                    System.out.println("Enter a valid choice !!");
                }
            }
        }

    }

    private static void displayAccountDetails(){
        for(Account a:accounts){
            if(a==null)return;
            System.out.println("Account ID: "+a.getId());
            System.out.println("Account Number: "+a.getAccountNumber());
            System.out.println();
        }
    }

    private static void transferMoney() {
        if(accounts[1]==null){
            System.out.println("Accounts not created yet!! Please First create the account");
            return;
        }
        displayAccountDetails();
        System.out.print("Enter the Sender's Account Number: ");
        int senderId=validateInt();
        System.out.print("Enter the Receiver's Account Number: ");
        int receiverId=validateInt();
        Account sender=getAccount(senderId);
        Account receiver=getAccount(receiverId);

        if(sender==null || receiver==null){
            System.out.println("Account not found");
        }
        else if(sender.getAccountNumber()==receiver.getAccountNumber()){
            System.out.println("Can't transfer money to same account !!");
        }
        else{
            System.out.print("Enter the amount to transfer: ");
            double amount=validateDouble();
            double senderBeforeBalance=sender.getBalance();
            sender.withdraw(amount);
            if(senderBeforeBalance==sender.getBalance()){
                System.out.println("Amount not Transferred !!");
            }
            else{
                receiver.deposit(amount);
                System.out.println("Amount Transferred Successfully !!");
            }
        }

    }

    private static int validateInt(){
        int temp;
        while(true){
            if(scanner.hasNextInt()){
                temp = scanner.nextInt();
                return temp;
            }
            else{
                System.out.print("Enter valid number: ");
                scanner.next();
            }
        }
    }
    private static double validateDouble(){
        double temp;
        while(true){
            if(scanner.hasNextDouble()){
                temp = scanner.nextDouble();
                return temp;
            }
            else{
                System.out.print("Enter valid number: ");
                scanner.next();
            }
        }
    }


    private static void showBalance() {
        if(accounts[0]==null){
            System.out.println("Account not created yet!! Please First create the account");
            return;
        }

        System.out.print("Enter the Account Number to show Balance: ");
        long accountNumber=validateLong();
        while(accountNumber<0){
            System.out.print("Enter Account Number in positive: ");
            accountNumber=scanner.nextLong();
        }
        Account account=getAccount(accountNumber);
        if(account==null){
            System.out.println("No such account found !!");
            return;
        }
        System.out.println("Total Balance :"+account.getBalance());
        System.out.println();
    }

    private static long validateLong(){
        long temp;
        while(true){
            if(scanner.hasNextLong()){
                temp = scanner.nextLong();
                return temp;
            }
            else{
                System.out.print("Enter valid number: ");
                scanner.next();
            }
        }
    }

    private static Account getAccount(long accountNumber) {
        for(Account a:accounts){
            if(a==null)return null;
            if(a.getAccountNumber()==accountNumber){
                return a;
            }
        }
        return null;
    }

    private static void depositMoney() {
        if(accounts[0]==null){
            System.out.println("Account not created yet!! Please First create the account");
            return;
        }
        displayAccountDetails();

        System.out.print("Enter the Account Number to Deposit Amount: ");
        long accountNumber=validateLong();
        while(accountNumber<0){
            System.out.print("Enter Account Number in positive: ");
            accountNumber=scanner.nextLong();
        }
        Account account=getAccount(accountNumber);
        if(account==null){
            System.out.println("No such account found !!");
            return;
        }
        System.out.print("Enter the amount to Deposit :");
        double amount=validateDouble();
        if(amount<0){
            System.out.println("Amount must be positive");
            return;
        }
        account.deposit(amount);
        System.out.println("Amount Deposited !!");
    }

    private static void withdrawMoney() {
        if(accounts[0]==null){
            System.out.println("Account not created yet!! Please First create the account");
            return;
        }
        displayAccountDetails();
        System.out.println("Enter the Account Number to withdraw money: ");
        long accountNumber=validateLong();
        while(accountNumber<0){
            System.out.print("Enter Account Number in positive: ");
            accountNumber=scanner.nextLong();
        }
        Account account=getAccount(accountNumber);
        if(account==null){
            System.out.println("No such account found !!");
            return;
        }
        System.out.print("Enter the amount of withdrawal :");
        double amount=validateDouble();
        account.withdraw(amount);
        System.out.println("Amount Withdrawn !!");
    }

    private static void displayMenu() {
        System.out.println();
        System.out.println("Welcome to Banking Application !! ");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Show Balance");
        System.out.println("5. Transfer Money");
        System.out.println("6. Exit");
        System.out.print("Enter your Choice: ");
    }

    private static void createAccount() {
        if(accountIndex==MAX_ACCOUNTS-1){
            System.out.println("Maximum Accounts Reached, Can't create more !!");
            return;
        }
        System.out.println("Enter which type of account you want to create: ");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.print("Enter your Choice: ");
        int choice=validateInt();
        while(!((choice==1) || (choice==2))){
            System.out.print("Enter a valid choice(1/2) :");
            choice=validateInt();
        }
        scanner.nextLine();

        switch (choice){
            case 1:{
                createSavingsAccount();
                break;
            }
            case 2:{
                createCurrentAccount();
                break;
            }
            default:{
                System.out.println("Please Enter a valid choice !");
            }
        }

    }

    private static void createCurrentAccount() {
        System.out.print("Enter your Name: ");
        String name= scanner.nextLine();
        System.out.print("Enter your Initial Balance :");
        double initialBalance=validateDouble();

        while(initialBalance<500){
            System.out.println("Enter Minimum 500Rs. as Balance !!");
            System.out.print("Enter Balance again: ");
            initialBalance=validateDouble();
        }

        Account account=new CurrentAccount(name,initialBalance);
        accounts[accountIndex++]=account;

        System.out.println();
        System.out.println("Current Account Created!!");
        System.out.println("Account Number: "+account.getAccountNumber());
    }

    private static void createSavingsAccount() {
        System.out.print("Enter your Name: ");
        String name= scanner.nextLine();
        System.out.print("Enter your Initial Balance :");
        double initialBalance= validateDouble();
        while(initialBalance<0){
            System.out.println("Enter Positive Balance !!");
            System.out.print("Enter Balance again: ");
            initialBalance= validateDouble();
        }

        Account account=new SavingsAccount(name,initialBalance);
        accounts[accountIndex++]=account;

        System.out.println();
        System.out.println("Savings Account Created!!");
        System.out.println("Account Number: "+account.getAccountNumber());
    }
}
