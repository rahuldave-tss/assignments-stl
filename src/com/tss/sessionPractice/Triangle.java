package com.tss.sessionPractice;

public class Triangle extends Shape{
    double base;
    double height;
    Triangle(double base,double height){
        this.base=base;
        this.height=height;
    }

    @Override
    public void area() {
        System.out.println("Area of Triangle is: "+(0.5*base*height));
    }
}
