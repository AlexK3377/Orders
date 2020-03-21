package ua.kiev.prog.marketplace.domain;

public class Customer {
    public final Integer id;
    public final String name;
    public final String telnumber;
    public final String address;

    public Customer(String name, String telnumber, String address) {
        this(null, name, telnumber, address);
    }

    public Customer(Integer id, String name, String telnumber, String address) {
        this.id = id;
        this.name = name;
        this.telnumber = telnumber;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", telnumber=" + telnumber +
                ", address='" + address + '\'' +
                '}';
    }
}
