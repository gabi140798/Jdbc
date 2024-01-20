package pl.pd.service;

import org.junit.Before;
import org.junit.Test;
import pl.pd.model.Samochod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ServiceTest {

    private Samochod car1;
    private Samochod car2;
    private Samochod car3;
    private List<Samochod> cars;
    private Service service;

    @Before
    public void init() {
        service = new Service();
        car1 = new Samochod("Toyota", "Corolla", 40000, 4000);
        car2 = new Samochod("Honda", "Civik", 50000, 5000);
        car3 = new Samochod("Ford", "Mondeo", 24000, 6000);
        cars = new ArrayList<>(Arrays.asList(car1, car2, car3));
    }

    @Test
   public void shouldReturnMostExpensiveCar() {
        Samochod result = service.mostExpensiveCar(cars);
        assertEquals(car2, result);
    }

    @Test
    public void shouldReturnCarWithMostPopularBrand() {
        Samochod result = service.mostPopularMarka(cars);
        assertEquals(car1, result);
    }

}