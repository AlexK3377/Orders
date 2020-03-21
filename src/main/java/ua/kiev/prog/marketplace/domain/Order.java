package ua.kiev.prog.marketplace.domain;

public class Order {
    public final Integer id;
    public final Integer productId;
    public final Integer quantity;
    public final Integer customerId;
    public final int price;

    public Order(Integer productId, Integer quantity, Integer customerId, int price) {
        this(null, productId, quantity, customerId, price);
    }

    public Order(Integer id, Integer productId, Integer quantity, Integer customerId, int price) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.customerId = customerId;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", customerId=" + customerId +
                ", price=" + price +
                '}';
    }
}
