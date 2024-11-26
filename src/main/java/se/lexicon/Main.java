package se.lexicon;

import se.lexicon.Model.Action;
import se.lexicon.Model.Conditional;
import se.lexicon.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // System.out.println("Hello world!");

        List<Product> products = new ArrayList<>();
        products.add(new Product("Iphone 6s", 100.00, 0));
        products.add(new Product("Iphone 7", 120.00, 7));
        products.add(new Product("Iphone SE", 120.00, 0));
        products.add(new Product("Iphone 8", 150.00, 5));
        products.add(new Product("Iphone 13", 5600.00, 25));
        products.add(new Product("Iphone 16", 10000.00, 25));
        products.add(new Product("Book of Apples History", 1500.00, 5));
        System.out.println();
        System.out.println("------ Exercise 1 ----------");


        Action printProduct = (p) -> System.out.println(p.toString());
        Conditional conditionalStockZero = (p) -> p.getStock() == 0;
        process(products, conditionalStockZero, printProduct);
        System.out.println();
        System.out.println("----- Exercise 2 -------");


        process(products,
                p -> p.getProductName().startsWith("B"),
                p -> System.out.println(p.getProductName())
        );
        System.out.println();
        System.out.println("--------- Exercise 3 ---------");

        process(products,
                p->p.getPrice() > 100 && p.getPrice() < 150,
                p -> System.out.println(p.getProductName())
        );
        System.out.println();
        System.out.println("------- Exercise 4----------");

        process(products,
                p -> (p.getStock() < 10) && (p.getStock() > 0),
                p -> p.setPrice(p.getPrice() * 1.5)
        );
        products.forEach(
                product -> System.out.println(product.toString())
        );

    }

    public static void process(List<Product> list, Conditional conditional, Action action) {

        for (Product product : list) {
            if (conditional.test(product)) {
                action.execute(product);
            }
        }
    }
}