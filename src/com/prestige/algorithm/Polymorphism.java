package com.prestige.algorithm;

/**
 * Created by prest on 6/4/2019.
 */
public class Polymorphism {

    public static void main(String[] args) {

        Shape shape = new Circle();
        shape.draw();
        shape.area();
    }

}

interface Shape {

    int i = 10;

    void draw();

    default void area(){
        System.out.println("Some Area");
    }
}

class Circle implements Shape{

    @Override
    public void draw() {

        System.out.println("Drawing a circle");
    }

//    @Override
//    public void area(){
//
//        System.out.println("Pi * R ** 2");
//    }
}
