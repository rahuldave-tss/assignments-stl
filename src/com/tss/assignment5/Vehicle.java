package com.tss.assignment5;

public interface Vehicle {

    static void vehicleInspection(Vehicle v){
        System.out.println("Inspection Complete: " + v.getClass().getSimpleName());
    }

    default void playHorn(){
        if(!isStarted()){
            System.out.println("Vehicle Not Started, So cannot honk.");
            return ;
        }
        if(isCanHonk()){
            System.out.println(getClass().getSimpleName() + " Honking");
        }
        else System.out.println("This " + getClass().getSimpleName() + " cannot Honk");
    }

    default void playMusic(){
        if(!isStarted()){
            System.out.println("Vehicle Not Started, So cannot Play Music.");
            return ;
        }
        if(this.isCanPlayMusic()){
            System.out.println(getClass().getSimpleName() + " playing Music");
        }
        else System.out.println("This " + getClass().getSimpleName() + " cannot play music");
    }

    default void start() {
        if(isStarted()){
            System.out.println(getClass().getSimpleName() + " is already started !!");
        }
        System.out.println(getClass().getSimpleName() + " Started");
        setStarted(true);
    }

    default void stop() {
        if(!isStarted()){
            System.out.println(getClass().getSimpleName() + " is not started yet!!");
        }
        System.out.println(getClass().getSimpleName() + " Stopped");
        setStarted(false);
    }

    void getFuelStatus();
    void chargeBattery();
    int getVehicleId();

    boolean isCanHonk();
    boolean isCanPlayMusic();

    boolean isStarted();
    void setStarted(boolean started);

}
