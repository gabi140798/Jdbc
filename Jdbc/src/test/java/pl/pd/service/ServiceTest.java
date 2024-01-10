package pl.pd.service;

import org.junit.Before;
import org.junit.Test;
import pl.pd.exceptions.CarNotFoundException;
import pl.pd.model.Car;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ServiceTest {

    private Service service;
    private Car c1;
    private Car c2;
    private Car c3;
    private Car c4;
    private Car c5;

    private List<Car> cars;

    @Before
    public void init() {
        service = new Service();

        c1 = new Car("Audi","RS6",700000,50000);
        c2 = new Car("BMW","M4",350000,0);
        c3 = new Car("Mercedes","E63",1000000,21000);
        c4 = new Car("Ford","Focus",60000,220000);
        c5 = new Car("Fiat","Seicento",2000,350000);
        cars = new ArrayList<>(List.of(c1, c2, c3, c4,c5));
    }


    @Test
    public void shouldReturnTheMostExpensiveCar() {
        Car expensive = c3;
        Car result = service.findTheMostExpensiveCar(cars);
        assertEquals(expensive,result);
    }

    @Test
    public void shouldReturnAllFords() {
        List<Car> ford = new ArrayList<>(List.of(c4));
        assertEquals(ford,service.carsByBrand(cars,"Ford"));
    }

    @Test
    public void shouldReturnTheMostCheapestCar() {
        Car cheapest = c5;
        Car result = service.findTheMostCheapestCar(cars);
        assertEquals(cheapest,result);
    }

    @Test(expected = CarNotFoundException.class)
    public void shouldReturnNullWhenListIsNull() {
        List<Car> list = null;
        assertNull(service.findTheMostCheapestCar(list));
    }
}