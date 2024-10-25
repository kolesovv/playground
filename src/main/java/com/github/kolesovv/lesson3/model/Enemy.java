package com.github.kolesovv.lesson3.model;

public class Enemy implements Mortal {

    private String name;
    private Integer health;

    public Enemy(String name, Integer health) {
        this.name = name;
        this.health = health;
    }

    public Integer getHealth() {
        return health < 0 ? 0 : health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void takeDamage(Integer damage) {
        health -= damage;
    }

    @Override
    public boolean isAlive() {
        return health >= 1;
    }
}
