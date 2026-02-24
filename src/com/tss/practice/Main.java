package com.tss.practice;

import java.time.LocalDate;
import java.util.function.*;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        BiFunction<Integer,Integer,Integer> biFunction=(a,b)-> a+b;

        Consumer<Integer> consumer=new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer*integer);
            }
        };

        Predicate<Integer> predicate=new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 1;
            }
        };

        Supplier<LocalDate> supplier=new Supplier<LocalDate>() {
            @Override
            public LocalDate get() {
                return LocalDate.now();
            }
        };

        int sum=addTwoNumber(biFunction,10,20);
        System.out.println("Sum :"+sum);

        squareOfNumber(consumer,10);

        boolean odd=checkForOdd(predicate,3);
        System.out.println(odd);

        LocalDate localDate=getTime(supplier);
        System.out.println(localDate);



    }

    private static LocalDate getTime(Supplier<LocalDate> supplier) {
        return supplier.get();
    }

    private static boolean checkForOdd(Predicate<Integer> predicate,Integer num) {
        return predicate.test(num);
    }

    private static void squareOfNumber(Consumer<Integer> consumer,int a) {
        consumer.accept(a);
    }

    private static int addTwoNumber(BiFunction<Integer, Integer, Integer> biFunction,int a,int b) {
        return biFunction.apply(a,b);
    }
}
