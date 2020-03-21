package ua.kiev.prog.flat.domain;

public class Flat {

    public final int id;
    public final String address;
    public final String district;
    public final int square;
    public final int rooms;
    public final int price;

    public Flat(int id, String address, String district, int square, int rooms, int price) {
        this.id = id;
        this.address = address;
        this.district = district;
        this.square = square;
        this.rooms = rooms;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", district='" + district + '\'' +
                ", square=" + square +
                ", rooms=" + rooms +
                ", price=" + price +
                '}';
    }
}
