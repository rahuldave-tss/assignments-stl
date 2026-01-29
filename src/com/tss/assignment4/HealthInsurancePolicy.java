package com.tss.assignment4;

import static com.tss.utils.Validate.*;

public class HealthInsurancePolicy extends Policy{
    public HealthInsurancePolicy(String name, double sumAssured, int policyDuration) {
        super(name,sumAssured,policyDuration);
    }

    @Override
    double calculatePremium() {
        return (0.07)*getSumAssured();
    }

    @Override
    boolean applyForClaim() {
        System.out.print("Enter the amount of claim: ");
        double claimAmount=validateDouble();
        if(getSumAssured()==0){
            System.out.println("Policy Already claimed!!");
            return false;
        }
        if(claimAmount>getSumAssured()){
            System.out.println("Amount greater than sum assured !!");
            return false;
        }
        double prevBalance=getSumAssured();
        setSumAssured(prevBalance-claimAmount);
        System.out.println("Claim Approved !!");
        return true;
    }
    public String toString(){
        return super.toString()+"\nPolicy Type: Health Insurance";
    }
}
