package com.tss.assignment5;
import static com.tss.assignment5.Constants.*;

public class Car implements NonElectricVehicle{

    private boolean canHonk;
    private boolean canPlayMusic;
    private boolean isStarted;
    private int vehicleId;

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

    Car(boolean canHonk, boolean canPlayMusic){
        vehicleId=id;
        id+=10;
        this.canHonk=canHonk;
        this.canPlayMusic=canPlayMusic;
    }
}
