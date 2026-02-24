package com.tss.assignment5;
import static com.tss.assignment5.Constants.*;
import static com.tss.utils.Validate.*;
import static com.tss.utils.GlobalConstants.*;


public class Main {
    public static void main(String[] args)  {
        while(true){
            displayMenu();
            int choice= validateInt();
            switch (choice){
                case 1:{
                    addVehicle();
                    break;
                }
                case 2:{
                    startVehicle();
                    break;
                }
                case 3:{
                    stopVehicle();
                    break;
                }
                case 4:{
                    chargeVehicle();
                    break;
                }
                case 5:{
                    playHorn();
                    break;
                }
                case 6:{
                    playMusic();
                    break;
                }
                case 7:{
                    getFuelStatus();
                    break;
                }
                case 8:{
                    performInspection();
                    break;
                }
                case 9:{
                    System.out.println("Have a Good Day!!");
                    return;
                }
                default:{
                    System.out.println("Enter a valid choice !!");
                }
            }
        }
    }

    private static void performInspection() {
        if(!isThereAnyVehicles())return;
        Vehicle v=getVehicleDetails();
        if(vehicleNotFound(v))playMusic();
        else Vehicle.vehicleInspection(v);
    }

    private static void getFuelStatus() {
        if(!isThereAnyVehicles())return;
        Vehicle v=getVehicleDetails();
        if(vehicleNotFound(v))playMusic();
        else v.getFuelStatus();
    }

    private static void playMusic() {
        if(!isThereAnyVehicles())return;
        Vehicle v=getVehicleDetails();
        if(vehicleNotFound(v))playMusic();
        else v.playMusic();
    }

    private static boolean vehicleNotFound(Vehicle v) {
        if(v==null){
            System.out.println("No such vehicle found !!");
            return true;
        }
        return false;
    }

    private static void playHorn() {
        if(!isThereAnyVehicles())return;
        Vehicle v=getVehicleDetails();
        if(vehicleNotFound(v))playHorn();
        else v.playHorn();
    }

    private static void chargeVehicle() {
        if(!isThereAnyVehicles())return;
        Vehicle v=getVehicleDetails();
        if(vehicleNotFound(v))chargeVehicle();
        else v.chargeBattery();
    }

    private static void stopVehicle() {
        if(!isThereAnyVehicles())return;
        Vehicle v=getVehicleDetails();
        if(vehicleNotFound(v))stopVehicle();
        else v.stop();
    }

    private static void startVehicle() {
        if(!isThereAnyVehicles())return;
        Vehicle v=getVehicleDetails();
        if(vehicleNotFound(v))startVehicle();
        else v.start();
    }

    private static Vehicle getVehicleDetails() {
        System.out.print("Enter the vehicle id :");
        int vehicleId=validateInt();
        Vehicle v=getVehicleFromId(vehicleId);
        return v;
    }

    private static boolean isThereAnyVehicles() {
        if(vehicleIndex==0){
            System.out.println("No vehicles Found !!");
            return false;
        }
        return true;
    }

    private static Vehicle getVehicleFromId(int vehicalId) {
        for(Vehicle v:vehicles){
            if(v==null)break;
            if(v.getVehicleId()==vehicalId)return v;
        }
        return null;
    }

    private static void addVehicle() {
        if(vehicleIndex==MAX_VEHICLES){
            System.out.println("Can't add more vehicles !!");
            return;
        }
        System.out.println("Which type vehicle you want to add: ");
        System.out.println("1. Non Electric Vehicle");
        System.out.println("2. Electric Vehicle");
        System.out.print("Enter your choice: ");
        int choice=validateInt();
        switch (choice){
            case 1:{
                createNonElectricVehicle();
                break;
            }
            case 2:{
                createElectricVehicle();
                break;
            }
            default:{
                System.out.println("Enter a valid choice !!");
            }
        }
    }

    private static void createElectricVehicle() {
        System.out.println("Which vehicle you want to add: ");
        System.out.println("1. Electric Car");
        System.out.println("2. Electric Bike");
        System.out.print("Enter your choice: ");
        int choice=validateInt();
        while(!(choice==1 || choice==2)){
            System.out.println("Enter a valid choice !!");
            System.out.print("Enter your choice: ");
            choice=validateInt();
        }
        boolean canHonk=false;
        boolean canPlayMusic=false;
        canPlayMusic=canPlayMusic();
        canHonk=canHonk();

        switch (choice){
            case 1:{
                Vehicle v=new ElectricCar(canHonk,canPlayMusic);
                vehicles[vehicleIndex++]=v;

                System.out.println("Electric Car Added !!");
                System.out.println("ID: "+v.getVehicleId());
                break;
            }
            case 2:{
                Vehicle v=new ElectricBike(canHonk,canPlayMusic);
                vehicles[vehicleIndex++]=v;

                System.out.println("Electric Bike Added !!");
                System.out.println("ID: "+v.getVehicleId());
                break;
            }
        }
    }

    private static void createNonElectricVehicle() {
        System.out.println("Which vehicle you want to add: ");
        System.out.println("1. Car");
        System.out.println("2. Bike");
        System.out.print("Enter your choice: ");
        int choice=validateInt();
        while(!(choice==1 || choice==2)){
            System.out.println("Enter a valid choice !!");
            System.out.print("Enter your choice: ");
            choice=validateInt();
        }
        boolean canHonk=false;
        boolean canPlayMusic=false;
        canPlayMusic=canPlayMusic();
        canHonk=canHonk();

        switch (choice){
            case 1:{
                Vehicle v=new Car(canHonk,canPlayMusic);
                vehicles[vehicleIndex++]=v;

                System.out.println("Car Added !!");
                System.out.println("ID: "+v.getVehicleId());
                break;
            }
            case 2:{
                Vehicle v=new Bike(canHonk,canPlayMusic);
                vehicles[vehicleIndex++]=v;

                System.out.println("Bike Added !!");
                System.out.println("ID: "+v.getVehicleId());
                break;
            }
        }
    }

    private static boolean canHonk() {
        boolean canHonk=false;
        System.out.print("Can it Honk?(Yes/No) :");
        String s=scanner.next();
        while(!(s.toLowerCase().equals("yes") || s.toLowerCase().equals("no"))){
            System.out.println("Please enter a valid answer !!");
            s=scanner.next();
        }
        if(s.toLowerCase().equals("yes")){
            canHonk=true;
        }
        return canHonk;
    }

    private static boolean canPlayMusic() {
        boolean canPlayMusic=false;
        System.out.print("Can it play music?(Yes/No) :");
        String s=scanner.next();
        while(!(s.toLowerCase().equals("yes") || s.toLowerCase().equals("no"))){
            System.out.println("Please enter a valid answer !!");
            s=scanner.next();
        }
        if(s.toLowerCase().equals("yes")){
            canPlayMusic=true;
        }
        return canPlayMusic;
    }

    private static void displayMenu() {
        System.out.println();
        System.out.println("Welcome to Vehicle Management System !! ");
        System.out.println("1. Add a Vehicle");
        System.out.println("2. Start Vehicle");
        System.out.println("3. Stop Vehicle");
        System.out.println("4. Charge Vehicle");
        System.out.println("5. Play Horn");
        System.out.println("6. Play Music");
        System.out.println("7. Get Fuel Status");
        System.out.println("8. Perform Vehicle Inspection");
        System.out.println("9. Exit");
        System.out.print("Enter your Choice: ");
    }
}
