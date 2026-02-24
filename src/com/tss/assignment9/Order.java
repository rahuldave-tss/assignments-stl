package com.tss.assignment9;

public class Order {
    private static int newId=101;
    private int orderId;
    private String customerName;
    private String productCategory;
    private int quantity;
    private double pricePerUnit;
    private Status status;

    Order(){}
    Order(String customerName,String productCategory,int quantity,double pricePerUnit,Status status){
        this.customerName=customerName;
        this.productCategory=productCategory;
        this.quantity=quantity;
        this.pricePerUnit=pricePerUnit;
        this.status=status;
    }

    public static int getNewId() {
        return newId;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", quantity=" + quantity +
                ", pricePerUnit=" + pricePerUnit +
                ", status=" + status +
                '}';
    }
}
