package com.tss.assignment4;

import static com.tss.utils.Validate.*;

public class LifeInsurancePolicy extends Policy{
    public LifeInsurancePolicy(String name,double sumAssured,int policyDuration){
        super(name,sumAssured,policyDuration);
    }

    @Override
    double calculatePremium() {
        return (0.05)*getSumAssured();
    }


    @Override
    boolean applyForClaim() {
        if(getSumAssured()==0){
            System.out.println("Policy already claimed !!");
            return false;
        }
        System.out.print("Enter the year of policy: ");
        int currentPolicyYear=validateInt();
        if(currentPolicyYear<getPolicyDuration()){
            System.out.println("Policy not matured yet !! Claim Declined !!");
            return false;
        }
        else{
            setSumAssured(0);
            System.out.println("Claim Approved !!");
        }
        return true;
    }
    public String toString(){
        return super.toString()+"\nPolicy Type: Life Insurance";
    }
}
