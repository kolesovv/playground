package com.github.kolesovv.lesson4;

import java.util.Collection;
import java.util.List;

public class CollectionRunner {

    public static void main(String[] args) {

        // Create 'String' list
        AstonList<String> stringAstonList = new AstonArrayList<>();

        // Add Strings to list
        stringAstonList.add("soup");
        stringAstonList.add("disaster");
        stringAstonList.add("mixture");
        stringAstonList.add("speech");
        System.out.println(stringAstonList);

        // Remove 'String' by index
        stringAstonList.remove(1);
        System.out.println(stringAstonList);

        // Add collection to list
        Collection<String> words = List.of("climate", "sector", "psychology", "population", "ad", "committee", "week");
        stringAstonList.addAll(words);
        System.out.println(stringAstonList);

        // Get size of list
        System.out.println("Size: " + stringAstonList.getSize());

        // Get 'String' by index
        int index = 3;
        System.out.printf("Object '%s' for '%d' index%n%n", stringAstonList.get(index), index);

        User user1 = new User("Michele", 18);
        User user2 = new User("Taylor", 29);
        User user3 = new User("Ingrid", 33);

        // Create 'User' list
        Collection<User> users = List.of(user1, user2, user3);

        // Initial list by collection
        AstonList<User> userAstonList = new AstonArrayList<>(users);
        System.out.println(userAstonList);

        // Get size of list
        System.out.println("Size: " + userAstonList.getSize());

        // Remove 'User' by index
        userAstonList.remove(1);
        System.out.println(userAstonList);

    }

    static class User implements Comparable<User> {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public int compareTo(User o) {
            return 0;
        }
    }
}
