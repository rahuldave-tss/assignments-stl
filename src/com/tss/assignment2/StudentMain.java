package com.tss.assignment2;

import java.util.Random;
import java.util.Scanner;

public class StudentMain {
    static Scanner scanner=new Scanner(System.in);
    private static final int maxCoursesAllowed=5;
    private static final int maxStudentsAllowed=10;
    static Student[] students = new Student[maxStudentsAllowed];
    static Course[] courses = new Course[maxCoursesAllowed];
    static int courseIndex=0;
    static int studentIndex=0;

    public static void main(String[] args) {
        System.out.println();
        System.out.println("Welcome to Student Profile Management System !!");
//        System.out.print("Enter the number of students (1-10): ");
//        int numberOfStudents=validateInt(scanner.nextInt(),maxStudentsAllowed,"students");
//        students=new Student[numberOfStudents];
//
//        System.out.print("Enter the number of courses (1-5): ");
//        int numberOfCourses=validateInt(scanner.nextInt(),maxCoursesAllowed,"courses");
//        courses=new Course[numberOfCourses];


        while(true){
            displayMenu();
            System.out.print("Enter your choice (0-8): ");
            int choice=scanner.nextInt();
            while(choice<0){
                System.out.print("Enter positive value for choice :");
                choice=scanner.nextInt();
            }

            switch (choice){
                case 1:{
                    addNewStudent();
                    break;
                }
                case 2:{
                    addNewCourse();
                    break;
                }
                case 3:{
                    displayStudentById();
                    break;
                }
                case 4:{
                    displayAllStudents();
                    break;
                }
                case 5:{
                    displayAllCourses();
                    break;
                }
                case 6:{
                    payFees();
                    break;
                }
                case 7:{
                    viewPendingFees();
                    break;
                }
                case 8:{
                    assignCourseToStudent();
                    break;
                }
                case 0:{
                    System.out.println("Have a Good Day !!");
                    return;
                }
                default:{
                    System.out.println("Enter a valid choice !!");
                }
            }
        }



    }

    private static void assignCourseToStudent() {
        displayAllStudents();
        System.out.print("Enter the id of student you want to add the course: ");
        int studentId= scanner.nextInt();
        while(studentId<0){
            System.out.print("Enter positive ID: ");
            studentId= scanner.nextInt();
        }
        Student s=getStudentById(studentId);
        if(s==null){
            System.out.println("Student Not available !!");
            assignCourseToStudent();
        }
        Course[] studentCourses=s.getCourses();
        displayAllCourses();
        System.out.print("Enter the course id you want to opt: ");
        int courseId= scanner.nextInt();
        while(courseId<0){
            System.out.print("Enter positive ID: ");
            courseId= scanner.nextInt();
        }
        if(checkIfCourseAlreadyOpted(studentCourses,courseId)){
            System.out.println("Course Already Opted");
            return;
        }
        Course c=getCourseFromId(courseId);
        if(c==null){
            System.out.println("No such course available");
        }
        int studentCourseIndex=findStudentCourseIndex(studentCourses);
        if(studentCourseIndex==studentCourses.length){
            System.out.println("Maximum Course Opted");
            return;
        }
        studentCourses[studentCourseIndex]=c;
        double fees=c.getCourseFees();
        double totalfees=fees+s.getTotalFees();
        s.setTotalFees(totalfees);

        System.out.println("Course Added Successfully !!");
    }

    private static int findStudentCourseIndex(Course[] studentCourses) {
        for(int i=0;i<studentCourses.length;i++){
            Course c=studentCourses[i];
            if(c==null)return i;
        }
        return studentCourses.length;
    }

//    private static void updateCourseDetails() {
//        System.out.print("Enter the id of the course you need to update: ");
//        int id= scanner.nextInt();
//        Course c=getCourseFromId(id);
//        if(c==null){
//            System.out.println("Enter a valid course id");
//            return;
//        }
//        double previousFees=c.getCourseFees();
//
//        scanner.nextLine();
//        System.out.print("Enter New Course Name: ");
//        String newName= scanner.nextLine();
//        System.out.print("Enter New Course Fees: ");
//        double newFees= scanner.nextDouble();
//        System.out.print("Enter New Course Duration: ");
//        int newDuration= scanner.nextInt();
//
//        double extraFees=newFees-previousFees;
//
//        for(Student s:students){
//            if(s==null)break;
//            for(Course course:s.getCourses()){
//                if(course==null)break;
//                if(course.getCourseId()==id){
//                    double totalFees=s.getTotalFees()+extraFees;
//                    s.setTotalFees(totalFees);
//                }
//            }
//        }
//        c.setCourseDuration(newDuration);
//        c.setCourseFees(newFees);
//        c.setCourseName(newName);
//        System.out.println("Course Details Updated Successfully !!");
//
//    }

    private static void viewPendingFees() {
        displayAllStudents();
        System.out.print("Enter the id of student to view his/her pending fees: ");
        int id= scanner.nextInt();
        Student s=getStudentById(id);
        if(s==null){
            System.out.println("Student not available !!");
            return;
        }
        System.out.println("Pending Fees: "+s.getPendingFees());

    }

    private static void payFees() {
        displayAllStudents();
        System.out.print("Enter the id of student to Pay his/her Fees: ");
        int id= scanner.nextInt();
        Student s=getStudentById(id);
        if(s==null){
            System.out.println("Student not available !!");
            return;
        }
        System.out.println("Total Fees: "+s.getTotalFees());
        System.out.println("Pending Fees: "+s.getPendingFees());
        System.out.print("Enter the amount you want to pay: ");
        double amount= scanner.nextDouble();
        while(amount<0 || amount> s.getTotalFees() || amount>s.getPendingFees()){
            System.out.println("Check the amount and Enter it again !");
            amount= scanner.nextDouble();
        }

        s.payFees(amount);

        System.out.println("Fees Paid Successfully !! ");

    }

    private static Student getStudentById(int id) {
        for(Student s:students){
            if(s==null)break;
            if(s.getId()==id){
                return s;
            }
        }
        return null;
    }

    private static void displayAllStudents() {
        if(students.length==0){
            System.out.println("No Students to Display !!");
            return;
        }
        for(Student s:students){
            if(s==null)break;
            s.displayProfile();
        }
    }

    private static void displayStudentById() {
        System.out.print("Enter the id of student to Display Profile: ");
        int id= scanner.nextInt();
        boolean available=false;
        for(Student s:students){
            if(s==null)break;
            if(s.getId()==id){
                s.displayProfile();
                available=true;
                break;
            }
        }
        if(!available){
            System.out.println("Student not available !!");
        }

    }

    private static void addNewCourse() {
        if(courseIndex >=maxCoursesAllowed){
            System.out.println("Maximum Courses Added !!");
            return;
        }

        System.out.println();
        System.out.println("Input the Course Details");
        System.out.println();
        int id=generateRandomNumber();
        if(courseIdAlreadyExists(id)){
            System.out.println("Random ID already exists");
            id=generateRandomNumber();
            System.out.println("Random Generated ID: "+id);
        }

        scanner.nextLine();
        System.out.println("Random Generated ID: "+id);
        System.out.print("Enter Course Name: ");
        String courseName= scanner.nextLine();

        if(courseNameAlreadyExists(courseName)){
            System.out.println("Course already exists");
            System.out.print("Enter Course Name: ");
            courseName= scanner.nextLine();
        }
        courseName=courseName.toLowerCase();

        System.out.print("Enter Course Fees: ");
        double courseFees=scanner.nextDouble();
        System.out.print("Enter Course Duration in months: ");
        int courseDuration= scanner.nextInt();

        Course course=new Course(id,courseName,courseFees,courseDuration);
        courses[courseIndex++]=course;
        System.out.println("Course Added Successfully !!");

    }

    private static boolean courseNameAlreadyExists(String courseName) {
        courseName=courseName.toLowerCase();
        for(Course c:courses){
            if(c==null)break;
            if(c.getCourseName().equals(courseName))return true;
        }
        return false;
    }

    private static boolean courseIdAlreadyExists(int id) {
        for(Course c:courses){
            if(c==null)break;
            if(c.getCourseId()==id)return true;
        }
        return false;
    }


    private static void addNewStudent() {
        if(studentIndex>=maxStudentsAllowed){
            System.out.println("Maximum Student Added !!");
            return;
        }
//        if(courseIndex==0){
//            System.out.println("Courses not Available, First please add the Course");
//            return;
//        }

        double totalFees=0;

        System.out.println("Input the Student Details");
        System.out.println();
        int id=generateRandomNumber();
        System.out.println("Random Generated ID: "+id);
        if(studentIdAlreadyExists(id)){
            System.out.println("Random ID already exists");
            id=generateRandomNumber();
            System.out.println("Random Generated ID: "+id);
        }
        scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String studentName= scanner.nextLine();
//        System.out.print("How many course do you want to opt? (1-3): ");
//        int numberOfCoursesOpted=scanner.nextInt();
//        while(numberOfCoursesOpted<0 || numberOfCoursesOpted>3){
//            System.out.println("Enter valid number of courses");
//            numberOfCoursesOpted=scanner.nextInt();
//        }
//
//        System.out.println();
//        displayAllCourses();
//        System.out.println();
//        int temp=numberOfCoursesOpted;
//        Course[] courseForStudent=new Course[3];
//        int index=0;
//        while(temp-->0){
//            System.out.print("Enter id of the courses the student want to opt : ");
//            int courseOpted=scanner.nextInt();
//            while(courseOpted<0){
//                System.out.println("Enter Positive Id");
//                courseOpted=scanner.nextInt();
//            }
//            if(checkIfCourseAlreadyOpted(courseForStudent,courseOpted)){
//                System.out.println("Course Already Opted ! Enter another one...");
//                temp++;
//                continue;
//            }
//            Course opted=getCourseFromId(courseOpted);
//            if(opted==null){
//                System.out.println("Invalid Course !!");
//                temp++;
//            }
//            else{
//                courseForStudent[index++]=opted;
//                totalFees+=opted.getCourseFees();
//            }

//        }
//        System.out.println("Total Fees: "+totalFees);
//
//        System.out.print("Enter Fees Paid: ");
//        double feesPaid= scanner.nextDouble();
//        while(feesPaid<0){
//            System.out.print("Enter Fees greater than 0: ");
//            feesPaid= scanner.nextDouble();
//        }
//        while(feesPaid>totalFees){
//            System.out.print("Enter Fees less than total fees: ");
//            feesPaid= scanner.nextDouble();
//        }

        Student student1=new Student(id,studentName);
        students[studentIndex++]=student1;

        System.out.println("Student Added Successfully !!");

    }

    private static boolean studentIdAlreadyExists(int id) {
        for(Student s:students){
            if(s==null)break;
            if(s.getId()==id)return true;
        }
        return false;
    }

    private static Course getCourseFromId(int courseOpted) {
        for(Course c:courses){
            if(c==null)break;
            if(c.getCourseId()==courseOpted){
                return c;
            }
        }
        return null;
    }

    private static boolean checkIfCourseAlreadyOpted(Course[] courseForStudent,int courseOpted) {
        for(Course c:courseForStudent){
            if(c==null)break;
            if(c.getCourseId()==courseOpted){
                return true;
            }
        }
        return false;
    }

    private static void displayAllCourses() {
        for(Course c:courses){
            if(c==null)break;
            System.out.println(c);
            System.out.println();
        }
    }

    private static int generateRandomNumber() {
        Random random=new Random();
        int randomNum=random.nextInt(1,101);
        return randomNum;
    }

    private static void displayMenu() {
        System.out.println();
        System.out.println("-----Student Profile Management System-----");
        System.out.println("1. Add a new Student");
        System.out.println("2. Add a new Course");
        System.out.println("3. Display a Student Profile");
        System.out.println("4. Display all Students");
        System.out.println("5. Display all Courses");
        System.out.println("6. Pay Fees");
        System.out.println("7. View Pending Fees");
        System.out.println("8. Add new course for student");
        System.out.println("0. Exit");
        System.out.println();
    }

    private static int validateInt(int number,int capacity,String value) {
        while(number<=0 || number>capacity){
            System.out.println("Enter positive number in (1-"+capacity+")");
            System.out.print("Enter the number of "+value+" : ");
            number=scanner.nextInt();
        }
        return number;
    }

}
