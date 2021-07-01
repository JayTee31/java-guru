package oop.playground;

import oop.playground.shapes.Circle;
import oop.playground.shapes.Point;
import oop.playground.television.Television;

import java.util.List;

public class Application {
    public static void main(String[] args) {
       final Television television = new Television();

        System.out.println(television.getChannel());

    }
}
