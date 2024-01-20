package pl.pd.service;

import pl.pd.exception.CarNotFound;
import pl.pd.model.Samochod;

import java.util.*;

public class Service {

    public  Samochod mostExpensiveCar(List<Samochod> list) {
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(Samochod::getCena))
                .orElseThrow(CarNotFound::new);
    }

    public Samochod mostPopularMarka(List<Samochod> list){
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(Samochod::getMarka))
                .orElseThrow(CarNotFound::new);
    }
}

