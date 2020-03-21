package ua.kiev.prog.marketplace.repository;

import ua.kiev.prog.DbProperties;
import ua.kiev.prog.marketplace.domain.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Customers {
    private final String tableName;
    private final DbProperties dbProperties;
    private final Connection connection;

    public Customers(DbProperties dbProperties) {
        this.tableName = "customers";
        this.dbProperties = dbProperties;
        this.connection = connection();
    }

    public void add(Customer customer) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO " + tableName + " (id, name, telnumber, address) VALUES (?,?,?,?);");
            preparedStatement.setObject(1, customer.id);
            preparedStatement.setString(2, customer.name);
            preparedStatement.setString(3, customer.telnumber);
            preparedStatement.setString(4, customer.address);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM " + tableName + " WHERE id=?");
            preparedStatement.setInt(1, id);
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