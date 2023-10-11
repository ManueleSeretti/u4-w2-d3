import shop.Customer;
import shop.Order;
import shop.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("libro1", "Books", 101.5);
        Product p2 = new Product("libro2", "Books", 23.5);
        Product p3 = new Product("libro3", "Books", 121.5);
        Product p4 = new Product("libro4", "Books", 71.5);
        Product p5 = new Product("libro5", "Books", 41.5);
        Product p6 = new Product("ciuccio", "Baby", 52.5);
        Product p7 = new Product("pannolini", "Baby", 47.5);
        Product p8 = new Product("scarpe", "Boy", 60);
        Product p9 = new Product("pantaloni", "Boy", 23);
        Product p10 = new Product("maglietta", "Boy", 28);

        List<Product> listaProdotti = new ArrayList<>();
        listaProdotti.add(p1);
        listaProdotti.add(p2);
        listaProdotti.add(p3);
        listaProdotti.add(p4);
        listaProdotti.add(p5);
        listaProdotti.add(p6);
        listaProdotti.add(p7);
        listaProdotti.add(p8);
        listaProdotti.add(p9);
        listaProdotti.add(p10);

        Customer c1 = new Customer("Mario", 3);
        Customer c2 = new Customer("Mario", 2);
        Customer c3 = new Customer("Mario", 2);
        Customer c4 = new Customer("Mario", 1);
        Customer c5 = new Customer("Mario", 2);

        List<Customer> listaCustomer = new ArrayList<>();

        listaCustomer.add(c1);
        listaCustomer.add(c2);
        listaCustomer.add(c3);
        listaCustomer.add(c4);
        listaCustomer.add(c5);

        LocalDate d1 = LocalDate.of(2021, 10, 10);
        LocalDate d2 = LocalDate.of(2021, 2, 10);
        LocalDate d3 = LocalDate.of(2021, 3, 15);
        LocalDate d4 = LocalDate.of(2021, 7, 22);
        LocalDate d5 = LocalDate.of(2021, 5, 30);

        Order o1 = new Order("consegnato", d1, listaProdotti, c1);
        Order o2 = new Order("consegnato", d2, listaProdotti, c2);
        Order o3 = new Order("consegnato", d3, listaProdotti, c3);
        Order o4 = new Order("consegnato", d4, listaProdotti, c4);
        Order o5 = new Order("consegnato", d5, listaProdotti, c5);

        List<Order> listaOrder = new ArrayList<>();
        listaOrder.add(o1);
        listaOrder.add(o2);
        listaOrder.add(o3);
        listaOrder.add(o4);
        listaOrder.add(o5);


        //ESERCIZIO 1

        Predicate<Product> productIsBooks = p -> p.getCategory().equals("Books");
        Predicate<Product> priceMore100 = p -> p.getPrice() > 100;

        List<Product> lista1 = listaProdotti.stream().filter(productIsBooks.and(priceMore100)).toList();
        System.out.println("elementi book con prezzo superiori a 100");
        lista1.forEach(el -> System.out.println(el));

        //ESERCIZIO 2
        Predicate<Product> productIsBaby = p -> p.getCategory().equals("Baby");
        List<Product> lista2 = listaProdotti.stream().filter(productIsBaby).toList();

        System.out.println("elementi categoria baby");
        lista2.forEach(el -> System.out.println(el));

        //ESERCIZIO 3
        Predicate<Product> productIsBoys = p -> p.getCategory().equals("Boy");
        List<Product> lista3 = listaProdotti.stream().filter(productIsBoys).toList();

        System.out.println("elementi categoria boy scontati del 10%");
        lista3.forEach(p -> {
            p.setSconto();
            System.out.println(p);
        });

        // ESERCIZIO 4
        LocalDate initialDate = LocalDate.of(2021, 2, 1);
        LocalDate finalDate = LocalDate.of(2021, 4, 1);
        Predicate<Order> orderIter2 = p -> p.getCustomer().getTier() == 2;
        Predicate<Order> orderDate = p -> p.getOrderDate().isAfter(initialDate) && p.getOrderDate().isBefore(finalDate);
        List<Order> lista4 = listaOrder.stream().filter(orderIter2.and(orderDate)).toList();

        System.out.println("ordini effettuati da clienti tier 2 tra il 1 feb e il 1 apr 2021");
        lista4.forEach(el -> System.out.println(el));
    }
}