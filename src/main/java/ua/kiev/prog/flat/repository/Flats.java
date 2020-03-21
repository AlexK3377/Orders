package ua.kiev.prog.flat.repository;

import ua.kiev.prog.DbProperties;
import ua.kiev.prog.flat.converter.ResultSetToFlatConverter;
import ua.kiev.prog.flat.domain.Flat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Flats {

    private final String tableName;
    private final ResultSetToFlatConverter converter;
    private final DbProperties dbProperties;
    private final Connection connection;

    public Flats(String dbPropertiesFile) {
        this.tableName = "flats";
        this.converter = new ResultSetToFlatConverter();
        this.dbProperties = new DbProperties(dbPropertiesFile);
        this.connection = connection();
    }

    public List<Flat> flats(int price) {
        final List<Flat> result = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + tableName + " WHERE price=?");
            preparedStatement.setInt(1, price);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result.add(converter.convert(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<Flat> flats(String district, int rooms) {
        final List<Flat> result = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + tableName + " WHERE district=? AND rooms=?");
            preparedStatement.setString(1, district);
            preparedStatement.setInt(2, rooms);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result.add(converter.convert(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public Flat flat(int id) {
        final List<Flat> flats = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + tableName + " WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                flats.add(converter.convert(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (flats.isEmpty()) {
            throw new RuntimeException("Flat with id=" + id + " not found");
        } else {
            return flats.get(0);
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
