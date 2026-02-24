package com.tss.sessionPractice;

public class Circle extends Shape{
    double radius;

    Circle(double radius){
        this.radius=radius;
    }

    @Override
    public void area() {
        System.out.println("Area of circle is : "+(3.14*radius*radius));
    }
}
