package com.github.kolesovv.lesson1.service;

import com.github.kolesovv.lesson1.model.Car;
import com.github.kolesovv.lesson1.model.Client;
import com.github.kolesovv.lesson1.model.Order;
import com.github.kolesovv.lesson1.model.StatusOrder;

import java.time.LocalDateTime;

public class OrderService {

    private static final Integer permissibleAge = 18;

    public void placement(Order order) {

        Car car = order.getCar();
        Client client = order.getClient();
        if (car.isBooked()) {
            order.setStatus(StatusOrder.CANCELLED);
        } else if (client.getAge() < permissibleAge) {
            order.setStatus(StatusOrder.CANCELLED);
        } else {
            car.setBooked(true);
            order.setStatus(StatusOrder.APPROVED);
        }
    }

    public void close(Order order) {

        order.setFinishBookTime(LocalDateTime.now());
        Car car = order.getCar();
        car.setBooked(false);
        order.setStatus(StatusOrder.COMPLETED);
    }
}
