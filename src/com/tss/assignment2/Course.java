package com.tss.assignment2;

public class Course {
    private int courseId;
    private String courseName;
    private double courseFees;
    private int courseDuration;

    public Course(){}

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseFees(double courseFees) {
        this.courseFees = courseFees;
    }

    public void setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
    }

    public Course(int courseId, String courseName, double courseFees, int courseDuration){
        this.courseDuration=courseDuration;
        this.courseFees=courseFees;
        this.courseName=courseName;
        this.courseId=courseId;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public double getCourseFees() {
        return courseFees;
    }

    public int getCourseDuration() {
        return courseDuration;
    }

    public String toString(){
        return  "Course ID: "+courseId+
                "\nCourse Name: "+courseName+
                "\nCourse Fees: "+courseFees+
                "\nCourse Duration: "+courseDuration;
    }

}
