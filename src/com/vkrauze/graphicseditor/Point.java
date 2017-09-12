package com.vkrauze.graphicseditor;

public class Point implements GeometricFigure {
    private int x;
    private int y;

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
        return String.format("Point (%d, %d).", x, y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
