package com.vkrauze.graphicseditor;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(0, 0, 2, 2);

        System.out.println(rectangle);
        System.out.println("Perimeter is " + rectangle.perimeter());
        System.out.println("Area is " + rectangle.area());

        Ellipse ellipse = new Ellipse(0, 0, 1, 1);

        System.out.println(ellipse);
        System.out.println("Perimeter is " + ellipse.perimeter());
        System.out.println("Area is " + ellipse.area());
    }
}
