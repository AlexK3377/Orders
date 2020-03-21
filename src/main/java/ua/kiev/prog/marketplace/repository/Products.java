package ua.kiev.prog.marketplace.repository;

import ua.kiev.prog.DbProperties;
import ua.kiev.prog.marketplace.domain.Customer;
import ua.kiev.prog.marketplace.domain.Product;

import java.sql.*;

public class Products {

    private final String tableName;
    private final DbProperties dbProperties;
    private final Connection connection;

    public Products(DbProperties dbProperties) {
        this.tableName = "products";
        this.dbProperties = dbProperties;
        this.connection = connection();

    }

    public void add(Product product) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO " + tableName + " (id,price, name, quantity) VALUES (?,?,?,?);");
            preparedStatement.setObject(1, product.id);
            preparedStatement.setDouble(2, product.price);
            preparedStatement.setString(3, product.name);
            preparedStatement.setInt(4, product.quantity);

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection connection() {
        try {
            return DriverManager.getConnection(dbProperties.getUrl(), dbProperties.getUser(), dbProperties.getPassword());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
