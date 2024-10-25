package com.github.kolesovv.lesson3.model;

public abstract class Hero {

    private String name;
    private Integer damage;

    public Hero(String name, Integer damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public Integer getDamage() {
        return damage;
    }

    public abstract void attackEnemy(Enemy enemy);
}
