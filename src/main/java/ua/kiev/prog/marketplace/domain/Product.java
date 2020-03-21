package ua.kiev.prog.marketplace.domain;

public class Product {
    public final Integer id;
    public final int price;
    public final String name;
    public final int quantity;

    public Product(int price, String name, int quantity) {
        this(null, price, name, quantity);
    }

    public Product(Integer id, int price, String name, int quantity) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}


