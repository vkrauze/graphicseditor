package com.vkrauze.graphicseditor;

import com.vkrauze.graphicseditor.display.GraphicsDisplay;
import com.vkrauze.graphicseditor.display.TextModeDisplay;
import com.vkrauze.graphicseditor.figure.*;

import java.util.ArrayList;
import java.util.List;

public class Editor {
    private static List<GeometricFigure> figures = new ArrayList<>();

    public static void main(String[] args) {
        addFigures();
        printFiguresInfo();

        new TextModeDisplay().render(figures);
        new GraphicsDisplay().render(figures);
    }

    private static void printFiguresInfo() {
        System.out.println("These geometric figure will be drawn:");
        for (GeometricFigure figure : figures) {
            System.out.println(String.format("%s It has perimeter of %.2f and area of %.2f.",
                    figure.toString(), figure.perimeter(), figure.area()));
        }
    }

    private static void addFigures() {
        figures.add(new Rectangle(30, 5, 90, 35));
        figures.add(new Ellipse(45, 25, 7, 3));
        figures.add(new Ellipse(45, 25, 2, 1));
        figures.add(new Ellipse(75, 25, 7, 3));
        figures.add(new Ellipse(75, 25, 2, 1));
        figures.add(new Line(40, 15, 60, 10));
        figures.add(new Line(80, 15, 60, 10));
        figures.add(new Point(55, 20));
        figures.add(new Point(65, 20));
    }
}
