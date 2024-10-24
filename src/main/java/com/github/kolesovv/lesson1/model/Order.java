package com.github.kolesovv.lesson1.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Order {

    private StatusOrder status;
    private final Client client;
    private final Car car;

    private LocalDateTime bookTime;

    private final LocalDateTime startBookTime;
    private LocalDateTime finishBookTime;

    public Order(Client client, Car car, LocalDateTime bookTime) {
        this.client = client;
        this.car = car;
        this.bookTime = bookTime;
        this.startBookTime = LocalDateTime.now();
        this.status = StatusOrder.PLACEMENT;
    }

    public StatusOrder getStatus() {
        return status;
    }

    public void setStatus(StatusOrder status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public Car getCar() {
        return car;
    }

    public LocalDateTime getBookTime() {
        return bookTime;
    }

    public LocalDateTime getStartBookTime() {
        return startBookTime;
    }

    public void setFinishBookTime(LocalDateTime finishBookTime) {
        this.finishBookTime = finishBookTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "status=" + status +
                ", client=" + client +
                ", vehicle=" + car +
                ", bookTime=" + bookTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) +
                ", startBookTime=" + startBookTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) +
                ", finishBookTime=" + (!Objects.equals(status.toString(), "COMPLETED") ?
                null : finishBookTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))) +
                '}';
    }
}
