package com.tss.temp;

//Implement Product (id, name, price) with validation.
//Store in ProductCatalog using Product[].
//Add method sortByPriceAsc()

public class Product {
    private int id;
    private String name;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(validatePrice(price)){
            this.price = price;
        }
    }

    private boolean validatePrice(double price) {
        if(price<0 || price>1000){
            return false;
        }
        return true;
    }

    Product(){}
    Product(int id,String name,double price){
        this.id=id;
        this.name=name;
        this.price=validatePrice(price)?price:0;
    }
    Product(int id,String name){
        this(id,name,0);
    }

//    public String toString(){
//        return "ID: "+
//    }



}
