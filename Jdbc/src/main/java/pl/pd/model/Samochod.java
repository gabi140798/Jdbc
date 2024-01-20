package pl.pd.model;

public class Samochod {
    // Stwórz klase samochod marka model cena przebieg. Stwórz kilka samochodow i zapisz je do bazy danych,
    // nastepnie usun jedno auto a potem inne zmien marke
    // odczytaj wszystkie auta
    private String marka;
    private String model;
    private double cena;
    private double przebieg;

    public Samochod(String marka, String model, double cena, double przebieg) {
        this.marka = marka;
        this.model = model;
        this.cena = cena;
        this.przebieg = przebieg;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public double getPrzebieg() {
        return przebieg;
    }

    public void setPrzebieg(int przebieg) {
        this.przebieg = przebieg;
    }

    @Override
    public String toString() {
        return marka;
    }
}
