package com.github.kolesovv.lesson1.model;

import java.util.Optional;

public class Client {

    private final String name;
    private Integer age;
    private Wallet wallet;

    public Client(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Optional<Wallet> getWallet() {
        return Optional.of(wallet);
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {

        return "Client{" +
                "name='" + name + '\'' +
                ", balance=" + wallet.getBalance() +
                '}';
    }
}
