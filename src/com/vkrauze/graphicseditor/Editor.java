package com.vkrauze.graphicseditor;

import com.vkrauze.graphicseditor.figures.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Editor {
    public static void main(String[] args) {
        Screen.clear();

        List<GeometricFigure> figures = new ArrayList<>();
/*
        figures.add(new Point(110, 20));
        figures.add(new Line(5, 5, 100, 10));
        figures.add(new Line(5, 10, 100, 15));
        figures.add(new Rectangle(10, 2, 80, 22));
*/
        figures.add(new Ellipse(10, 10, 5, 5));

        System.out.println("These geometric figures will be drawn:");
        for (GeometricFigure figure : figures) {
            System.out.println(String.format("%s It has perimeter of %.2f and area of %.2f.",
                    figure.toString(), figure.perimeter(), figure.area()));
            figure.draw();
        }

        Screen.show();
    }
}
