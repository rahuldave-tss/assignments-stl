package com.tss.sessionPractice;

public class Rectangle extends Shape{
    double length;
    double breadth;

    Rectangle(double length,double breadth){
        this.length=length;
        this.breadth=breadth;
    }
    @Override
    public void area() {
        System.out.println("Area of Rectangle is: "+(length*breadth));
    }
}
