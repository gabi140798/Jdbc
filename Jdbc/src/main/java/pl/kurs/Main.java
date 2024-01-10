package pl.kurs;


import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {


        // polaczenie do bazy danych za pomoca connection string

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/world?useSSL=false&serverTimezone=UTC", // useSSL czy uzywamy szyfrowania, strefa sczasowa
                "root",
                "root"
        );

        // statement tez jest interfejsem, za jego pomoca bedzie mozna zrobic resukt set z wynikami
        Statement statement = connection.createStatement();

        // do pobierania rekordow uzywamy executeQuery() natomiast do dodawania, usuwania itd uzywamy executeUpdate()
        // INSERT dodawnie rekordow

        String insertQuery = "insert into klienci values(null, 'Kuba', 'Jakis'),(null, 'Asia', 'Jakas')";
//
        int insertedRows = statement.executeUpdate(insertQuery);
//
        System.out.println("ilosc dodanych rekordow: " + insertedRows);



        // DELETE usuwanie rekordow

     //   String deleteQuery = "delete from klienci where idklienta > 10";
//
     //   int deletedRows = statement.executeUpdate(deleteQuery);
//
     //   System.out.println("ilosc usunietych rekordow: " + deletedRows);

        //UPDATE aktualizacja rekordow

        String updateQuery = "update klienci set imie = 'Adam' where idklienta > 7";
//
        int updatedRows = statement.executeUpdate(updateQuery);
//
        System.out.println("ilosc zaktualizowanych rekordow: " + updatedRows);


        // zapytanie na pobranie rekordow

        String selectQuery = "select idklienta, imie, nazwisko from klienci";

        // result set - wyniki danego zapytania

        ResultSet resultSet = statement.executeQuery(selectQuery);

        // rekordy wyswietlamy w petli while
        while(resultSet.next()){
            int idklienta = resultSet.getInt("idklienta");
            String imie = resultSet.getString("imie");
            String nazwisko = resultSet.getString("nazwisko");
            System.out.println(idklienta + " " + imie + " " + nazwisko);
        }









    }
}
