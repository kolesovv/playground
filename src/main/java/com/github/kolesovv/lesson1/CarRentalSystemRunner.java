package com.github.kolesovv.lesson1;

import com.github.kolesovv.lesson1.model.*;
import com.github.kolesovv.lesson1.repository.CarRepository;
import com.github.kolesovv.lesson1.service.OrderPaymentService;
import com.github.kolesovv.lesson1.service.OrderService;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CarRentalSystemRunner {

    public static void main(String[] args) {

        // Creating a user
        Client speedRacer = new Client("SpeedRacer", 30);

        // Creating a wallet with deposit
        Wallet wallet = new Wallet(new BigDecimal(10_000));
        speedRacer.setWallet(wallet);

        // Fleet initialization
        CarRepository carRepository = new CarRepository();

        // Creating and placing an order
        Order orderUser = new Order(speedRacer, carRepository.getById(0), LocalDateTime.now().plusDays(5));
        OrderService orderService = new OrderService();
        orderService.placement(orderUser);

        // Payment
        if (orderUser.getStatus().equals(StatusOrder.APPROVED)) {
            OrderPaymentService orderPaymentService = new OrderPaymentService(orderUser);
            orderPaymentService.payment();
            orderPaymentService.printBill();
        }

        System.out.println(orderUser);

        // Finalizing a booking
        try {
            Thread.sleep(5_000);
            orderService.close(orderUser);
            System.out.println(orderUser);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
