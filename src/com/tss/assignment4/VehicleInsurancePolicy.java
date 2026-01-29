package com.tss.assignment4;

import static com.tss.utils.Validate.*;

public class VehicleInsurancePolicy extends Policy{

    public VehicleInsurancePolicy(String name,double sumAssured,int policyDuration){
        super(name,sumAssured,policyDuration);
    }
    @Override
    double calculatePremium() {
        return (0.03)*getSumAssured();
    }

    @Override
    boolean applyForClaim() {
        System.out.print("Enter the year of policy: ");
        int currentPolicyYear=validateInt();
        if(currentPolicyYear<=getPolicyDuration()){
            System.out.print("Enter the amount of claim: ");
            double claimAmount=validateDouble();
            if(claimAmount>getSumAssured()){
                System.out.println("Amount greater than sum assured !!");
                return false;
            }
            double prevBalance=getSumAssured();
            setSumAssured(prevBalance-claimAmount);
            System.out.println("Claim Approved !!");
            return true;
        }
        else System.out.println("Policy not active !! Claim Declined !!");
        return false;
    }
    public String toString(){
        return super.toString()+"\nPolicy Type: Vehicle Insurance";
    }
}
