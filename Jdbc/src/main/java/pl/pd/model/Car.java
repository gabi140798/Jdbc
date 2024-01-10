package pl.pd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString

public class Car {
    // Stwórz klase samochod marka model cena przebieg. Stwórz kilka samochodow i zapisz je do bazy danych,
    // nastepnie usun jedno auto a potem inne zmien marke
    // odczytaj wszystkie auta

    private String brand;
    private String model;
    private double price;
    private int mileage;

}
