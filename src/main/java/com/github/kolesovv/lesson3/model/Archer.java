package com.github.kolesovv.lesson3.model;

public class Archer extends Hero {

    public Archer(String name, Integer damage) {
        super(name, damage);
    }

    @Override
    public void attackEnemy(Enemy enemy) {

        enemy.takeDamage(super.getDamage());
        System.out.println(super.getName() + " is shooting a bow at the " + enemy.getName());
    }
}
