package com.vkrauze.graphicseditor.figure;

import java.util.Arrays;
import java.util.List;

public class Line extends GeometricFigure {
    private List<Point> ends;

    @Override
    public double perimeter() {
        return 0;
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Line from (%d, %d) to (%d, %d).",
                ends.get(0).getX(), ends.get(0).getY(),
                ends.get(1).getX(), ends.get(1).getY());
    }

    public double length() {
        double edge1 = (double) ends.get(0).getX() - ends.get(1).getX();
        double edge2 = (double) ends.get(0).getY() - ends.get(1).getY();
        return Math.sqrt(Math.pow(edge1, 2) + Math.pow(edge2, 2));
    }

    public Line(List<Point> ends) {
        this.ends = ends;
    }

    public Line(int x1, int y1, int x2, int y2) {
        ends = Arrays.asList(new Point(x1, y1), new Point(x2, y2));
    }

    public List<Point> getEnds() {
        return ends;
    }

    public void setEnds(List<Point> ends) {
        this.ends = ends;
    }

}
