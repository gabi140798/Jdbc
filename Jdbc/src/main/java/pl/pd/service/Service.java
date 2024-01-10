package pl.pd.service;

import pl.pd.exceptions.CarNotFoundException;
import pl.pd.model.Car;

import java.util.*;

public class Service {

    public Car findTheMostExpensiveCar(List<Car> list){
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(Car::getPrice))
                .orElseThrow(CarNotFoundException::new);
    }

    public List<Car> carsByBrand(List<Car> list, String brand) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(c -> c.getBrand() != null)
                .filter(c -> c.getBrand().equals(brand))
                .toList();
    }

    public Car findTheMostCheapestCar(List<Car> list){
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .min(Comparator.comparing(Car::getPrice))
                .orElseThrow(CarNotFoundException::new);
    }

}
