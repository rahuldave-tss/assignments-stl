package com.tss.assignment5;

public interface ElectricVehicle extends Vehicle{
    default void chargeBattery(){
        System.out.println("Charging !!!!");
    }

    default void getFuelStatus(){
        System.out.println("Can't get Fuel status, This is Electric Vehicle !!");
    }
}
