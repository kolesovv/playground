package com.github.kolesovv.lesson3;

import com.github.kolesovv.lesson3.model.*;

import java.util.List;

public class BattleGround {

    public static void main(String[] args) {

        Warrior warrior = new Warrior("Artur", 15);
        Mage mage = new Mage("Harry", 20);
        Archer archer = new Archer("Robin", 5);

        Enemy enemy = new Enemy("Alien", 100);

        List<Hero> heroes = List.of(warrior, mage, archer);
        for (Hero hero : heroes) {
            hero.attackEnemy(enemy);
        }

        System.out.println(enemy.getHealth());
        System.out.println(enemy.isAlive());
    }
}
