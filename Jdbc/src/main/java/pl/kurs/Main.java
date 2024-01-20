package pl.kurs;


import com.sun.source.tree.ConditionalExpressionTree;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws SQLException {


        // polaczenie do bazy danych za pomoca connection string

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/biblioteka?useSSL=false&serverTimezone=UTC", // useSSL czy uzywamy szyfrowania, strefa sczasowa
                "root",
                "rootroot"
        );

        // statement tez jest interfejsem, za jego pomoca bedzie mozna zrobic resukt set z wynikami
        Statement statement = connection.createStatement();

        // do pobierania rekordow uzywamy executeQuery() natomiast do dodawania, usuwania itd uzywamy executeUpdate()
        // INSERT dodawnie rekordow

      //  String insertQuery = "insert into klienci values(null, 'Kuba', 'Jakis'),(null, 'Asia', 'Jakas')";
//
      //  int insertedRows = statement.executeUpdate(insertQuery);
//
      //  System.out.println("ilosc dodanych rekordow: " + insertedRows);



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

        // Stwórz klase samochod marka model cena przebieg. Stwórz kilka samochodow i zapisz je do bazy danych,
        // nastepnie usun jedno auto a potem inne zmien marke
        // odczytaj wszystkie auta


        String select= "select nazwisko from klienci where imie = 'Adam' || 1 = 1";

        ResultSet resultSet1 = statement.executeQuery(select);

        // rekordy wyswietlamy w petli while
        while(resultSet1.next()){
            String nazwisko = resultSet1.getString("nazwisko");
            System.out.println(nazwisko);
        }

        String select1= "select autor, tytul from ksiazki where idksiazki < ? && cena < ?";

        PreparedStatement preparedStatement = connection.prepareStatement(select1);
        preparedStatement.setInt(1, 5);
        preparedStatement.setInt(2, 50);

        ResultSet resultSet2 = preparedStatement.executeQuery();
        while(resultSet2.next()){
            String autor = resultSet2.getString("autor");
            String tytul = resultSet2.getString("tytul");
            System.out.println(autor + " " + tytul);
        }

        // klasa BasicDataSource - umozliwia twoerzenie puli polaczen do bazy danych
        // nie bedziemy musieli fizycznie zamykac, niszczyc polaczen
        // zamiast tworzyc nowe polaczenie bedziemy mogli skorzystac z jakiegos ktore jest juz utworzone
        // tworzymy obiekt i za pomoca setow ustawiamy wartosci

        System.out.println("Drugi sposob polaczenia");
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl( "jdbc:mysql://localhost:3306/biblioteka?useSSL=false&serverTimezone=UTC");
        basicDataSource.setUsername( "root");
        basicDataSource.setPassword("rootroot");

// zamykanie polaczen bez rzucania sql exceptioon
        //po kolei tworzymy obiekty
        Connection connection1 = null;
        Statement statement1 = null;
        ResultSet resultSet3 = null;
        try{
           // przypisujemy je w try catch
            connection1 = basicDataSource.getConnection();
            statement1 = connection1.createStatement();
            resultSet3 = statement1.executeQuery("select * from klienci");

            while(resultSet3.next()){
                String imie = resultSet3.getString("imie");
                String nazwisko = resultSet3.getString("nazwisko");
                System.out.println(imie + " " + nazwisko);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            // zamykamy polaczenie w odwrotnej kolejnosci
            try{
                if (resultSet3 != null){
                    resultSet3.close();
                }
                if ( statement1 != null){
                    statement1.close();
                }
                if (connection1 != null){
                    connection1.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }











    }
}
