package com.tss.assignment8;

import static com.tss.utils.Validate.*;

public class PaymentApp {
    public static void main(String[] args) {
        while(true){
            displayMenu();
            int choice=validateInt();
            System.out.println();
            System.out.print("Enter Amount: ");
            double amount=validateDouble();

            switch (choice){
                case 1:{
                    processPayment(a-> {
                        if(a<=50000)return true;
                        return false;
                    },amount,"UPI");
                    break;
                }
                case 2:{
                    processPayment(a->(a<=100000),amount,"Credit Card");
                    break;
                }
                case 3:{
                    processPayment(a->true,amount,"NetBanking");
                    break;
                }
                default:{
                    System.out.println("Enter a valid choice !!");
                }
            }
        }
    }

    private static void displayMenu() {
        System.out.println();
        System.out.println("Payment Options :");
        System.out.println("1. UPI");
        System.out.println("2. Credit Card");
        System.out.println("3. NetBanking");
        System.out.println();
        System.out.print("Enter your choice: ");
    }


    static void processPayment(Payment payment,double amount,String name){
        boolean state=payment.pay(amount);
        System.out.println("Processing "+name+" payment of Rs. "+amount);
        if(state){
            System.out.println("Payment Successful !!");
        }
        else System.out.println("Payment Failed !!");
    }
}
