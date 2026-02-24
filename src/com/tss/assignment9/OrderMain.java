package com.tss.assignment9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderMain {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();

        orders.add(new Order("Rahul", "Electronics", 2, 200, Status.PENDING));
        orders.add(new Order("Jayesh", "Toys", 5, 100, Status.DELIVERED));
        orders.add(new Order("Neel", "Electronics", 1, 500, Status.SHIPPED));
        orders.add(new Order("Jayesh", "Skincare", 3, 1000, Status.PENDING));

        orders.add(new Order("Jayesh", "Electronics", 4, 1500, Status.SHIPPED));
        orders.add(new Order("Amit", "Clothing", 6, 800, Status.DELIVERED));
        orders.add(new Order("Amit", "Electronics", 2, 2500, Status.SHIPPED));
        orders.add(new Order("Neha", "Clothing", 9, 1200, Status.PENDING));

        orders.add(new Order("Rahul", "Groceries", 7, 300, Status.DELIVERED));
        orders.add(new Order("Jayesh", "Clothing", 2, 2000, Status.DELIVERED));
        orders.add(new Order("Neel", "Clothing", 1, 1500, Status.SHIPPED));


        System.out.println("1. All Orders from Jayesh: ");
        orders.stream().
                filter((Order o) -> o.getCustomerName().equalsIgnoreCase("Jayesh"))
                .forEach(System.out::println);

        System.out.println();
        System.out.println("2. Only Delivered Orders: ");
        orders.stream().
                filter((Order o) -> o.getStatus().toString().equalsIgnoreCase("Delivered"))
                .forEach(System.out::println);

        System.out.println();
        System.out.println("3. Product Categories: ");
        orders.stream()
                .map((Order o) -> o.getProductCategory())
                .distinct()
                .forEach(System.out::println);

        System.out.println();
        System.out.println("4. Revenue of all shipped orders: ");
        double revenue =
                orders.stream()
                        .filter((Order o) -> o.getStatus().toString().equalsIgnoreCase("Shipped"))
                        .map((Order o) -> o.getQuantity() * o.getPricePerUnit())
                        .reduce(0.0, Double::sum);
        System.out.println(revenue);

        System.out.println();
        System.out.println("5. Avg quantity of items for Electronics Category");
        double avgQuantity =
                orders.stream()
                        .filter((Order o) -> o.getProductCategory().equalsIgnoreCase("Electronics"))
                        .mapToInt((Order o) -> o.getQuantity())
                        .average()
                        .orElse(0);
        System.out.println(avgQuantity);

        System.out.println();
        System.out.println("6. Order with highest total value");
        double highestOrder =
                orders.stream()
                        .map(o -> o.getQuantity() * o.getPricePerUnit())
                        .reduce(0.0, Double::max);
        System.out.println(highestOrder);

        System.out.println();
        System.out.println("7. Group order by status and display orders by status");
        Map<Status, Long> statusCount = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getStatus,       // key mapper
                        Collectors.counting()   // downstream collector
                ));
        System.out.println(statusCount);

        System.out.println();
        System.out.println("8. List of customers who have more than 2 orders");
//        List<String> customers=
//                orders.stream()
//                        .map(Order::getCustomerName)
//                        .distinct()
//                        .filter(name->orders.stream()
//                                .filter(o->o.getCustomerName().equalsIgnoreCase(name))
//                                .count()>2)
//                        .toList();

        List<String> customers =
                orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomerName, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 2)
                .map(Map.Entry::getKey)
                .toList();

        System.out.println(customers);

        System.out.println();
        System.out.println("9. Sort orders by total value desc and print top 3");
        orders.stream()
                .map(o->o.getQuantity()*o.getPricePerUnit())
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("10. Check if all orders in \"Clothing\" category have quantity <10 ");
        boolean check=
                orders.stream()
                .filter(o->o.getProductCategory().equalsIgnoreCase("Clothing"))
                .allMatch(o->o.getQuantity()<10);
        System.out.println(check);


    }
}
