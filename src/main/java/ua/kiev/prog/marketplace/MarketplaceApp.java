package ua.kiev.prog.marketplace;

import ua.kiev.prog.DbProperties;
import ua.kiev.prog.marketplace.domain.Customer;
import ua.kiev.prog.marketplace.domain.Order;
import ua.kiev.prog.marketplace.domain.Product;
import ua.kiev.prog.marketplace.repository.Customers;
import ua.kiev.prog.marketplace.repository.Orders;
import ua.kiev.prog.marketplace.repository.Products;

public class MarketplaceApp {
    public static void main(String[] args) {
        DbProperties dbProperties = new DbProperties("marketplaceDB.properties");
        Customers customers = new Customers(dbProperties);
        Customer customer = new Customer("Customer100", "+380671234567", "abc str.");
        customers.add(customer);
//        customers.add(new Customer("Customer5", "+380671234567", "abc str."));
//        customers.add(new Customer("Customer6", "+380671234567", "abc str."));
//        customers.add(new Customer("Customer7", "+380671234567", "abc str."));

//        customers.remove(1);
        Products products = new Products(dbProperties);
        Product product = new Product(50,"tomato",100);
        products.add(product);
//        products.add(new Product(60,"potato",20));
        Orders orders = new Orders(dbProperties);
        orders.add(new Order(1, 2, 5, 10));

    }
}
