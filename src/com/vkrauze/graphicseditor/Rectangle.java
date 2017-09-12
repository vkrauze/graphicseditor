package com.vkrauze.graphicseditor;

import java.util.Arrays;
import java.util.List;

public class Rectangle implements GeometricFigure {
    private List<Line> edges;

    @Override
    public double perimeter() {
        return edges.stream()
                .mapToDouble(Line::length)
                .sum();
    }

    @Override
    public double area() {
        return edges.stream()
                .mapToDouble(Line::length)
                .distinct()
                .reduce(1, (length1, length2) -> length1 * length2);
    }

    @Override
    public String toString() {
        return edges.stream()
                .flatMap(line -> line.getEnds().stream())
                .distinct()
                .peek(point -> System.out.println("Unique " + point.toString()))
                .map(Point::toString)
                .reduce("", String::concat);
    }

    public Rectangle(List<Line> edges) {
        this.edges = edges;
    }

    public Rectangle(int diagonalX1, int diagonalY1, int diagonalX2, int diagonalY2) {
        Point corner1 = new Point(diagonalX1, diagonalY1);
        Point corner2 = new Point(diagonalX2, diagonalY2);
        Point corner3 = new Point(diagonalX2, diagonalY2);
        Point corner4 = new Point(diagonalX1, diagonalY2);

        Line edge1 = new Line(Arrays.asList(corner1, corner2));
        Line edge2 = new Line(Arrays.asList(corner2, corner3));
        Line edge3 = new Line(Arrays.asList(corner3, corner4));
        Line edge4 = new Line(Arrays.asList(corner4, corner1));

        edges = Arrays.asList(edge1, edge2, edge3, edge4);
    }

    public List<Line> getEdges() {
        return edges;
    }

    public void setEdges(List<Line> edges) {
        this.edges = edges;
    }
}
