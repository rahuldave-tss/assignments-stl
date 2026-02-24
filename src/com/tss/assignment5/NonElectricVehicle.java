package com.tss.assignment5;

public interface NonElectricVehicle extends Vehicle{

    default void getFuelStatus(){
        System.out.println("Print Fuel Status...");
    }

    default void chargeBattery(){
        System.out.println("Can't charge , This is Not Electric !!");
    }
}
