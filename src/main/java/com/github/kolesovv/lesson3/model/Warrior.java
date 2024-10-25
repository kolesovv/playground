package com.github.kolesovv.lesson3.model;

public class Warrior extends Hero {

    public Warrior(String name, Integer damage) {
        super(name, damage);
    }

    @Override
    public void attackEnemy(Enemy enemy) {

        enemy.takeDamage(super.getDamage());
        System.out.println(super.getName() + " is throwing a spear at the " + enemy.getName());
    }
}
