package com.tss.assignment4;

import java.util.Random;

public abstract class Policy {
    private long policyNumber;
    private String policyHolderName;
    private double sumAssured;
    private int policyDuration;
    private static long policyNum=101;

    Policy(){}

    public void setSumAssured(double sumAssured) {
        this.sumAssured = sumAssured;
    }

    public long getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public double getSumAssured() {
        return sumAssured;
    }

    public int getPolicyDuration() {
        return policyDuration;
    }

    public static long getPolicyNum() {
        return policyNum;
    }

    public Policy(long policyNumber, String policyHolderName, double sumAssured, int policyDuration){
        this.policyDuration=policyDuration;
        this.policyHolderName=policyHolderName;
        this.policyNumber=policyNumber;
        this.sumAssured=sumAssured;
    }
    Policy(String policyHolderName,double sumAssured,int policyDuration){
        this(generatePolicyNumber(),policyHolderName,sumAssured,policyDuration);
    }

    private static long generatePolicyNumber() {
        long policyNumber=policyNum*2+1;
        policyNum+=50;
        return policyNumber;
    }

    public String toString(){
        return "Policy Number: "+policyNumber
                +"\nPolicy Holder Name: "+policyHolderName
                +"\nSum Assured: "+sumAssured
                +"\nPolicy Duration: "+policyDuration;
    }


    abstract double calculatePremium();
    abstract boolean applyForClaim();


}
