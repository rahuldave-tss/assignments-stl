package com.tss.assignment5;

import static com.tss.assignment5.Constants.id;

public class ElectricCar implements ElectricVehicle{
    private final boolean canHonk;
    private final boolean canPlayMusic;
    private boolean isStarted;
    private final int vehicleId;

    public int getVehicleId() {
        return vehicleId;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean started) {
        isStarted = started;
    }

    public boolean isCanHonk() {
        return canHonk;
    }

    public boolean isCanPlayMusic() {
        return canPlayMusic;
    }

    ElectricCar(boolean canHonk, boolean canPlayMusic){
        vehicleId=id;
        id+=10;
        this.canHonk=canHonk;
        this.canPlayMusic=canPlayMusic;
    }

}
