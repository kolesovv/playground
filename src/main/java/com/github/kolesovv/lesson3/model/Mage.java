package com.github.kolesovv.lesson3.model;

public class Mage extends Hero {

    public Mage(String name, Integer damage) {
        super(name, damage);
    }

    @Override
    public void attackEnemy(Enemy enemy) {

        enemy.takeDamage(super.getDamage());
        System.out.println(super.getName() + " is spelling at the " + enemy.getName());
    }
}
