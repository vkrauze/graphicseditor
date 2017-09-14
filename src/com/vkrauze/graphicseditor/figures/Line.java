package com.vkrauze.graphicseditor.figures;

import com.vkrauze.graphicseditor.Screen;

import java.util.Arrays;
import java.util.List;

public class Line implements GeometricFigure {
    private List<Point> ends;

    public void draw() {
        int x1 = ends.get(0).getX();
        int y1 = ends.get(0).getY();
        int x2 = ends.get(1).getX();
        int y2 = ends.get(1).getY();

        if (x1 != x2) {
            float slope = ((float) y2 - y1) / (x2 - x1);
            int smallerX = Math.min(x1, x2);
            int largerX = Math.max(x1, x2);
            for (int x = smallerX; x <= largerX; x++) {
                int y = (int) (slope * (x - x1) + y1);
                Screen.setPoint(x, y);
            }
        } else {
            int smallerY = Math.min(y1, y2);
            int largerY = Math.max(y1, y2);
            for (int y = smallerY; y <= largerY; y++) {
                Screen.setPoint(x1, y);
            }
        }
    }

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
