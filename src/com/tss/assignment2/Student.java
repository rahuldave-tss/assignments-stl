package com.tss.assignment2;

import java.util.Arrays;

public class Student {
    private int id;
    private String name;
    private Course[] courses=new Course[3];
    private double feesPaid;
    private double totalFees;

    public Student(){}
    public Student(int id,String name){
        this.id=id;
        this.name=name;
    }
    public Student(int id,String name,Course[] courses,double feesPaid,double totalFees){
        this.id=id;
        this.name=name;
        this.courses=courses;
        this.feesPaid=feesPaid;
        this.totalFees=totalFees;
    }

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

    public Course[] getCourses() {
        return courses;
    }

    public double getFeesPaid() {
        return feesPaid;
    }
    public void setFeesPaid(double feesPaid) {
        this.feesPaid = feesPaid;
    }

    public double getTotalFees() {
        return totalFees;
    }
    public void setTotalFees(double totalFees) {
        this.totalFees = totalFees;
    }

    public void payFees(double amount){
        feesPaid+=amount;
    }

    public double getPendingFees(){
        return totalFees-feesPaid;
    }

    public void displayProfile(){
        System.out.println();
        System.out.println("Student ID: "+id);
        System.out.println("Student Name: "+name);
        System.out.println("Student Courses: ");
        printCourses();
        System.out.println("Fees Paid: "+feesPaid);
        System.out.println("Total Fees: "+totalFees);
        System.out.println();
    }

    private void printCourses() {
        if(courses[0]==null){
            System.out.println("No Courses Opted");
            return;
        }
        for(Course c:courses){
            if(c==null)break;
            System.out.println(c);
            System.out.println();
        }
    }

}
