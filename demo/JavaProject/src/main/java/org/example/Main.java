package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Animal {
    Animal() {
        System.out.println("Animal created");
    }
    String color = "white";

    void eat() {
        System.out.println("Animal eats");
    }
}

class Dog extends Animal {
    Dog() {
        super();
        System.out.println("Dog created");
    }
    String color = "black";

    void printColor() {
        System.out.println(color);//prints color of Dog class
        System.out.println(super.color);//prints color of Animal class
    }
    void bark() {
        System.out.println("Dog barks");
    }
void work() {
        bark();
    super.eat();
}
    void eat() {
        System.out.println("Dog munches");
        super.eat();
    }

}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Dog d = new Dog();
        d.printColor();
        d.work();
       List<Integer> numberList = new ArrayList<>();
       numberList.add(1);
       numberList.add(2);
       numberList.add(3);
       numberList.add(2);
       numberList.add(1);
        System.out.println(numberList);

        Set<Integer> numSet = new HashSet<>(numberList);
        //numSet.addAll(numberList);
        System.out.println(numSet);

    }
}