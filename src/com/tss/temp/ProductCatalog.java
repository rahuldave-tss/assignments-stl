package com.tss.temp;

import java.util.Arrays;

public class ProductCatalog {
    public static final int MAX_PRODUCTS=3;
    Product[] products= new Product[MAX_PRODUCTS];
    int index=0;

    public Product[] getProducts() {
        return products;
    }
    public void addProduct(Product product){
        if(index==MAX_PRODUCTS){
            System.out.println("Maximum Product Added");
            return;
        }
        products[index++]=product;
        System.out.println("Product Added Successfully");
    }

    public void sortProductsByPrice(){
        Arrays.sort(products, (a,b)-> {
            return (int) (a.getPrice() - b.getPrice());
        });
    }
}
