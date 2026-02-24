package com.tss.assignment3;

import com.tss.exceptions.NegativeAmountException;

import java.util.ArrayList;
import java.util.List;
import static com.tss.utils.Validate.*;

public class Main {
    static List<Account> accounts=new ArrayList<>();

    public static void main(String[] args) {
        while(true) {
            try {
                displayMenu();
                int choice = validateInt();
                switch (choice) {
                    case 1: {
                        createAccount();
                        break;
                    }
                    case 2: {
                        depositMoney();
                        break;
                    }
                    case 3: {
                        withdrawMoney();
                        break;
                    }
                    case 4: {
                        showBalance();
                        break;
                    }
                    case 5: {
                        transferMoney();
                        break;
                    }
                    case 6: {
                        showTransactions();
                        break;
                    }
                    case 7: {
                        deleteAccount();
                        break;
                    }
                    case 8: {
                        System.out.println("Have a Good Day!!");
                        return;
                    }
                    default: {
                        System.out.println("Enter a valid choice !!");
                    }
                }

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private static void deleteAccount() {
        Account account=selectAccount();
        accounts.remove(account);
        System.out.println("Account Deleted !!");
    }

    private static void showTransactions() {
        Account account=selectAccount();
        System.out.println("Statement for Account Number: "+account.getAccountNumber()+"\nAccount Holder Name: "+account.getCustomerName());
        System.out.println();
        System.out.printf(
                "%-10s | %-10s | %-15s | %-15s | %-10s%n",
                "Txn ID", "Type", "Sender Acc No",
                "Receiver Acc No", "Amount"
        );
        System.out.println("--------------------------------------------------------------------------");
        List<Transaction> transactions=account.getTransactionList();
        for(Transaction t:transactions){
            System.out.println(t);
            System.out.println();
        }

    }

    private static void displayAccountDetails(){
        for(Account a:accounts){
            if(a==null)return;
            System.out.println("Account ID: "+a.getId());
            System.out.println("Account Number: "+a.getAccountNumber());
            System.out.println("Account Type: "+a.getClass().getSimpleName());
            System.out.println();
        }
    }

    private static void transferMoney() {
        if(accounts.size()<2){
            throw new IllegalStateException("Accounts not created yet!! Please First create the account");
        }
//        displayAccountDetails();
        System.out.println("Enter the Sender's Details: ");
        Account sender=selectAccount();
        Account receiver;

        while(true){
            System.out.println("Enter the Receiver's Details: ");
            receiver=selectAccount();
            if(sender!=receiver)break;
            System.out.println("Can't transfer money to same account !!");
        }

        System.out.print("Enter the amount to transfer: ");
        double amount=validateDouble();

        sender.withdraw(amount);
        receiver.deposit(amount);

        Transaction t=new Transaction(sender.getAccountNumber(), receiver.getAccountNumber(), TransactionType.TRANSFER.toString(),amount);
        List<Transaction> s=sender.getTransactionList();
        List<Transaction> r=receiver.getTransactionList();

        s.add(t);
        r.add(t);
        System.out.println("Amount Transferred Successfully !!");

    }


    private static void showBalance() {
        Account account=selectAccount();
        System.out.println("Total Balance :"+account.getBalance());
        System.out.println();
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
        Account account=selectAccount();
        System.out.print("Enter the amount to Deposit :");
        double amount=validateDouble();
        if(amount<0){
            throw new NegativeAmountException();
        }
        account.deposit(amount);

        Transaction t=new Transaction(account.getAccountNumber(),TransactionType.DEPOSIT.toString(),amount);
        List<Transaction> l=account.getTransactionList();
        l.add(t);

        System.out.println("Amount Deposited !!");
    }

    private static void withdrawMoney() {
        Account account=selectAccount();
        System.out.print("Enter the amount of withdrawal :");
        double amount=validateDouble();
        if(amount<0){
            throw new NegativeAmountException();
        }

        while(true){
            try{
                account.withdraw(amount);
                break;
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                System.out.print("Enter amount again: ");
            }
        }

        Transaction t=new Transaction(account.getAccountNumber(), TransactionType.WITHDRAW.toString(),amount);
        List<Transaction> l=account.getTransactionList();
        l.add(t);

        System.out.println("Amount Withdrawn !!");
    }

    private static Account selectAccount() {
        if(accounts.isEmpty()){
            throw new IllegalStateException("No Accounts Found !!");
        }
        displayAccountDetails();
        while(true){
            try{
                System.out.println("Enter the Account Number : ");
                long accountNumber=validateLong();
                Account account=getAccount(accountNumber);
                if(account==null){
                    throw new IllegalArgumentException("No Account is associated with this account number !!");
                }
                return account;
            }
            catch(RuntimeException e){
                System.err.println(e.getMessage());
            }
        }

    }

    private static void displayMenu() {
        System.out.println();
        System.out.println("Welcome to Banking Application !! ");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Show Balance");
        System.out.println("5. Transfer Money");
        System.out.println("6. Show Transactions");
        System.out.println("7. Delete Account");
        System.out.println("8. Exit");
        System.out.print("Enter your Choice: ");
    }

    private static void createAccount() {

        System.out.println("Enter which type of account you want to create: ");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.print("Enter your Choice: ");
        int choice=validateInt();
        while(!((choice==1) || (choice==2))){
            System.out.print("Enter a valid choice(1/2) :");
            choice=validateInt();
        }

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
        String name= validateString();
        System.out.print("Enter your Initial Balance :");
        double initialBalance=validateDouble();

        while(initialBalance<500){
            System.out.println("Enter Minimum 500Rs. as Balance !!");
            System.out.print("Enter Balance again: ");
            initialBalance=validateDouble();
        }

        Account account=new CurrentAccount(name,initialBalance);
        accounts.add(account);

        System.out.println();
        System.out.println("Current Account Created!!");
        System.out.println("Account Number: "+account.getAccountNumber());
    }

    private static void createSavingsAccount() {
        System.out.print("Enter your Name: ");
        String name= validateString();
        System.out.print("Enter your Initial Balance :");
        double initialBalance= validateDouble();
        Account account=new SavingsAccount(name,initialBalance);
        accounts.add(account);

        System.out.println();
        System.out.println("Savings Account Created!!");
        System.out.println("Account Number: "+account.getAccountNumber());
    }
}
