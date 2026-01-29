package com.tss.utils;

import static com.tss.utils.GlobalConstants.scanner;

public class Validate {

    public static int validateInt(){
        int temp;
        while(true){
            if(scanner.hasNextInt()){
                temp = scanner.nextInt();
                while(temp<0){
                    System.out.print("Enter positive number: ");
                    temp = validateInt();

                }
                return temp;
            }
            else{
                System.out.print("Enter valid number: ");
                scanner.next();
            }
        }
    }
    public static double validateDouble(){
        double temp;
        while(true){
            if(scanner.hasNextDouble()){
                temp = scanner.nextDouble();
                while(temp<0){
                    System.out.print("Enter positive number: ");
                    temp = validateDouble();
                }
                return temp;
            }
            else{
                System.out.print("Enter valid number: ");
                scanner.next();
            }
        }
    }
    public static long validateLong(){
        long temp;
        while(true){
            if(scanner.hasNextLong()){
                temp = scanner.nextLong();
                while(temp<0){
                    System.out.print("Enter positive number: ");
                    temp = validateLong();
                }
                return temp;
            }
            else{
                System.out.print("Enter valid number: ");
                scanner.next();
            }
        }
    }
}
