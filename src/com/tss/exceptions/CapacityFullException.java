package com.tss.exceptions;

public class CapacityFullException extends Exception{
    int maxx;
    public CapacityFullException(int maxx){
        this.maxx=maxx;
    }

    @Override
    public String getMessage() {
        return "Capacity of movies is full !!. Max allowed movies: "+maxx;
    }
}
