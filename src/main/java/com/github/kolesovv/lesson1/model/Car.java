package com.github.kolesovv.lesson1.model;

public class Car {

    private final String name;
    private final Classifier aClassifier;
    private boolean isBooked;

    public Car(String name, Classifier aClassifier) {
        this.name = name;
        this.aClassifier = aClassifier;
    }

    public String getName() {
        return name;
    }

    public Classifier getClassifier() {
        return aClassifier;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", class=" + aClassifier +
                '}';
    }
}
