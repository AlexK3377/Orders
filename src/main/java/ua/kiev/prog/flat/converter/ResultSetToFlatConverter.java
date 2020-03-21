package ua.kiev.prog.flat.converter;

import ua.kiev.prog.flat.domain.Flat;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetToFlatConverter {

    public Flat convert(ResultSet resultSet) {
        try {
            return new Flat(
                    resultSet.getInt("id"),
                    resultSet.getString("adress"),
                    resultSet.getString("district"),
                    resultSet.getInt("square"),
                    resultSet.getInt("rooms"),
                    resultSet.getInt("price")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
