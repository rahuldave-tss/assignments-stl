package com.tss.assignment3;

public class Transaction {
    public static int transactionId=1;
    public int id;
    public long senderAccNumber;
    public long receiverAccNumber;
    public String transactionType;
    public double amount;

    Transaction(){}
    Transaction(long senderAccNumber,long receiverAccNumber,String transactionType,double amount){
        this(senderAccNumber, transactionType, amount);
        this.receiverAccNumber=receiverAccNumber;
    }
    Transaction(long senderAccNumber,String transactionType,double amount){
        this.id=transactionId;
        transactionId+=10;
        this.senderAccNumber=senderAccNumber;
        this.transactionType=transactionType;
        this.amount=amount;
    }

    @Override
    public String toString() {
        String sender = "       -";
        String receiver = "       -";

        if (transactionType.equalsIgnoreCase("deposit")) {
            receiver = senderAccNumber+"";
        }
        else if (transactionType.equalsIgnoreCase("withdraw")) {
            sender = senderAccNumber+"";
        }
        else { // transfer
            sender = senderAccNumber+"";
            receiver = receiverAccNumber+"";
        }

        return String.format(
                "%-10s | %-10s | %-15s | %-15s | %-10s",
                id,
                transactionType,
                sender,
                receiver,
                amount
        );
    }

}
