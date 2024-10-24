package com.github.kolesovv.lesson1.repository;

import com.github.kolesovv.lesson1.model.Car;
import com.github.kolesovv.lesson1.model.Classifier;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {

    private List<Car> carList = new ArrayList<>();

    {
        carList.add(new Car("Tesla Model X", Classifier.BUSINESS));
        carList.add(new Car("Hyundai Accent", Classifier.COMFORT));
        carList.add(new Car("Toyota GR Yaris", Classifier.SPORT));
        carList.add(new Car("Nissan NV200", Classifier.ECONOMY));
        carList.add(new Car("Mitsubishi Outlander PHEV", Classifier.COMFORT));
    }

    public List<Car> getAll() {
        return carList;
    }

    public Car getById(Integer id) {
        return carList.get(id);
    }

    public void add(Car car) {
        carList.add(car);
    }
}
