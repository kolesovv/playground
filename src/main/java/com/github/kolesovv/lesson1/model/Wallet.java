package com.github.kolesovv.lesson1.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Wallet {

    private static final Integer ACCURACY = 2;
    private static final RoundingMode roundingMode = RoundingMode.HALF_UP;
    private BigDecimal balance;

    public Wallet() {
    }

    public Wallet(BigDecimal balance) {
        this.balance = balance;
    }

    public void deposit(BigDecimal amount) {

        if (amount == null) {
            throw new IllegalArgumentException("Amount is null");
        } else if (amount.doubleValue() <= 0) {
            throw new RuntimeException("The amount must be greater than zero");
        } else {
            balance = balance.add(amount).setScale(ACCURACY, roundingMode);
        }
    }

    public void withdraw(BigDecimal amount) {

        if (amount == null) {
            throw new IllegalArgumentException("Amount is null");
        } else if (amount.doubleValue() <= 0) {
            throw new RuntimeException("The amount must be greater than zero");
        } else if ((balance.subtract(amount).doubleValue()) < 0) {
            throw new RuntimeException("Not enough money in your wallet");
        } else {
            balance = balance.subtract(amount).setScale(ACCURACY, roundingMode);
        }
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
