package pl.pd;

import pl.pd.model.Samochod;
import pl.pd.service.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        // Stwórz klase samochod marka model cena przebieg. Stwórz kilka samochodow i zapisz je do bazy danych,
        // nastepnie usun jedno auto a potem inne zmien marke
        // odczytaj wszystkie auta
        // klasa serwisowa + 3 metody jakies chcecie i testyy`
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/biblioteka?useSSL=false&serverTimezone=UTC",
                "root",
                "rootroot"
        );

        Statement statement = connection.createStatement();

//        String insertQuery = "insert into samochod values('Bmw', 'X5', 900000, 17000),('Toyota', 'Corolla', 45000, 11111)";
//        int insertedRows = statement.executeUpdate(insertQuery);
//        System.out.println("ilosc dodanych rekordow: " + insertedRows);

//        String deleteQuery = "delete from samochod where model = 'X5'";
//        int deleteRows = statement.executeUpdate(deleteQuery);
//        System.out.println("ilosc usunietych rekordow: " + deleteRows);

        String updateQuery = "update samochod set model = 'M3' where marka = 'Bmw'";
        int updateRows = statement.executeUpdate(updateQuery);
        System.out.println("ilosc zaktualizowanych rekordow: " + updateRows);

        String selectQuery = "select marka, model, cena, przebieg from samochod";

        ResultSet resultSet = statement.executeQuery(selectQuery);

        List<Samochod> samochody = new ArrayList<>();
        while(resultSet.next()){
            String marka = resultSet.getString("marka");
            String model = resultSet.getString("model");
            double cena = resultSet.getDouble("cena");
            double przebieg = resultSet.getDouble("przebieg");

            Samochod samochod = new Samochod(marka, model, cena, przebieg);
            samochody.add(samochod);
            System.out.println(marka + " " + model + " " + cena + " " + przebieg);
        }
        Service service = new Service();
        System.out.println("Most expensive car: " + service.mostExpensiveCar(samochody));
        System.out.println("Most popular car: " + service.mostPopularMarka(samochody));
   }
}
