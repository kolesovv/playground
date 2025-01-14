package com.github.kolesovv.lesson1.service;

import com.github.kolesovv.lesson1.model.Client;
import com.github.kolesovv.lesson1.model.Order;
import com.github.kolesovv.lesson1.model.StatusOrder;
import com.github.kolesovv.lesson1.model.Wallet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

public class OrderPaymentService {

    private final static Integer accuracy = 2;
    private final static RoundingMode roundingMode = RoundingMode.HALF_UP;
    private final Order order;
    private BigDecimal basicDailyRate = BigDecimal.valueOf(100);
    private Double classCoefficient;

    public OrderPaymentService(Order order) {
        this.order = order;
    }

    public void payment() {

        BigDecimal bill = getBill();
        Client client = order.getClient();
        Optional<Wallet> optionalWallet = client.getWallet();
        if (optionalWallet.isPresent()) {
            optionalWallet.get().withdraw(bill);
            order.setStatus(StatusOrder.IN_PROCESS);
        } else {
            throw new RuntimeException("The wallet has not been created");
        }
    }

    private BigDecimal getBill() {

        LocalDateTime startBookTime = order.getStartBookTime();
        LocalDateTime bookTime = order.getBookTime();
        Long days = ChronoUnit.DAYS.between(startBookTime, bookTime);
        determineClassCoefficient();

        return basicDailyRate
                .multiply(BigDecimal.valueOf(days))
                .multiply(BigDecimal.valueOf(classCoefficient))
                .setScale(accuracy, roundingMode);
    }

    private void determineClassCoefficient() {

        switch (order.getCar().getClassifier()) {
            case ECONOMY -> classCoefficient = 1.0;
            case COMFORT -> classCoefficient = 1.2;
            case BUSINESS -> classCoefficient = 1.8;
            case LUXURY -> classCoefficient = 2.0;
            case SPORT -> classCoefficient = 1.5;
        }
    }

    public void printBill() {

        System.out.println("Bill");
        System.out.println("Car: " + order.getCar().getName());
        System.out.println("Class: " + order.getCar().getClassifier());
        System.out.println("Amount: " + getBill());
        System.out.println();
    }
}
