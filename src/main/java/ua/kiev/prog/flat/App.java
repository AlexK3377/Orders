package ua.kiev.prog.flat;

import ua.kiev.prog.flat.domain.Flat;
import ua.kiev.prog.flat.repository.Flats;

import java.sql.SQLException;
import java.util.List;

public class App {
    public static void main(String[] args) throws SQLException {
        Flats flats = new Flats("flatDB.properties");
        List<Flat> flatsByPrice = flats.flats(70);
        List<Flat> findByDistrictAndRoms = flats.flats("Solomenskiy", 3);
        Flat flat = flats.flat(1);
        System.out.println(flatsByPrice);
        System.out.println();
        System.out.println(findByDistrictAndRoms);
        System.out.println();
        System.out.println(flat);
    }
}
