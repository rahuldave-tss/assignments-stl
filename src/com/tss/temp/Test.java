package com.tss.temp;

public class Test {
    public static void main(String[] args) {
        Product p1=new Product(1,"Soap",200);
        Product p2=new Product(2,"Shampoo",500);
        Product p3=new Product(3,"Brush",20);

        ProductCatalog pc=new ProductCatalog();
        pc.addProduct(p1);
        pc.addProduct(p2);
        pc.addProduct(p3);

        pc.sortProductsByPrice();

        for(Product p: pc.products){
            if(p==null)break;
            System.out.println("Id: "+p.getId());
            System.out.println("Name: "+p.getName());
            System.out.println("Price: "+p.getPrice());
        }

    }
}
