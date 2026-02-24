package com.tss.sessionPractice;

import com.tss.exceptions.AgeNotValidException;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        List<Student> l=new ArrayList<>();
//        l.add(new Student(5,"Rahul"));
//        l.add(new Student(2,"Neel"));
//        l.add(new Student(4,"Smit"));
//
//
//        Collections.sort(l, Main::compareById);
//        Collections.sort(l, (Student s1,Student s2)->s1.getId()-s2.getId());
//        System.out.println(l);
//        System.out.println();
//        Collections.sort(l, Main::compareByName);
//        System.out.println(l);

//        ExecutorService executorService= Executors.newSingleThreadExecutor();
//        ExecutorService executorService= Executors.newScheduledThreadPool(100000);
//        ExecutorService executorService= Executors.newFixedThreadPool(5);
//        ExecutorService executorService= Executors.newCachedThreadPool();

//        Future<Integer> future=executorService.submit(()->{
//            for(int i=0;i<20;i++){
//                System.out.println("1st Task "+ i);
//            }
//            return 0;
//        });
//
//        future.cancel(false);
//        Integer result= future.get();
//
//
//
//        executorService.submit(()->{
//            for(int i=0;i<10;i++){
//                System.out.println("2nd Task "+ i);
//            }
//        });
//
//        executorService.shutdown();

        String[] names={"Jayesh","Nimesh","Mark","Mahesh","Ramesh"};

        System.out.println("First 3 in asc order");
        Arrays.stream(names).
                limit(3).
                sorted().
                forEach(System.out::println);

        System.out.println();
        System.out.println("First 3 in asc order if it contains 'a'");

        Arrays.stream(names).
                limit(3).
                filter((name) -> name.contains("a")).
                sorted().
                forEach(System.out::println);

        System.out.println();
        System.out.println("All students in descending order");

        Arrays.stream(names).
                sorted(Comparator.reverseOrder()).
                forEach(System.out::println);

        System.out.println();
        System.out.println("First 3 characters of all names");

        Arrays.stream(names).
                map((name)->name.substring(0,3)).
                forEach(System.out::println);

        System.out.println();
        System.out.println("Names of students that contains <=4 char");

        Arrays.stream(names).
                filter((name)->name.length()<=4).
                forEach(System.out::println);






    }
//    public static int compareById(Student s1, Student s2) {
//        return s1.getId()-s2.getId();
//    }
//    public static int compareByName(Student s1, Student s2) {
//        return s1.getName().compareTo(s2.getName());
//    }
}
