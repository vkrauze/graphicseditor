package com.vkrauze.graphicseditor;

import java.util.List;

public class Line implements GeometricFigure {
    private List<Point> ends;

//    private Point point1;
//    private Point point2;

    @Override
    public Integer perimeter() {
        return 0;
    }

    @Override
    public Integer area() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Line from (%d, %d) to (%d, %d).",
                ends.get(0).getX(), ends.get(0).getY(),
                ends.get(1).getX(), ends.get(1).getY());
    }

    public List<Point> getEnds() {
        return ends;
    }

    public void setEnds(List<Point> ends) {
        this.ends = ends;
    }

/*
    @Override
    public String toString() {
        return String.format("Line from (%d, %d) to (%d, %d).",
                point1.getX(), point1.getY(), point2.getX(), point2.getY());
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }
*/
}
