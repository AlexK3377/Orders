package ua.kiev.prog.marketplace.repository;

import ua.kiev.prog.DbProperties;
import ua.kiev.prog.marketplace.domain.Order;

import java.sql.*;

public class Orders {

    private final String tableName;
    private final DbProperties dbProperties;
    private final Connection conn;

    public Orders(DbProperties dbProperties) {
        this.tableName = "orders";
        this.dbProperties = dbProperties;
        this.conn = conn();
    }

    public void add(Order order) {

        try {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO " + tableName + " (id,price,productId,customerId,quantity) VALUES (?,?,?,?,?);");
            preparedStatement.setObject(1, order.id);
            preparedStatement.setInt(2, order.price);
            preparedStatement.setInt(3, order.productId);
            preparedStatement.setInt(4, order.customerId);
            preparedStatement.setInt(5, order.quantity);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private Connection conn() {
        try {
            return DriverManager.getConnection(dbProperties.getUrl(), dbProperties.getUser(), dbProperties.getPassword());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
//    private static void addOrders()throws SQLException {
//        PreparedStatement ps = conn.prepareStatement("INSERT into orders(price,name,quantity)values(25,Tomato,100)");
//
//    }



