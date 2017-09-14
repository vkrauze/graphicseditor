package com.vkrauze.graphicseditor.figures;

import com.vkrauze.graphicseditor.Screen;

public class Ellipse implements GeometricFigure{
    int centerX;
    int centerY;
    int halfAxisX;
    int halfAxisY;

    @Override
    public void draw() {
        for (int x = -halfAxisX; x <= +halfAxisX; x++) {
            if (x == -halfAxisX || x == +halfAxisX)
                Screen.setPoint(x + centerX, centerY);
            else {
                double a = (double)1 / Math.pow(halfAxisY, 2);
                double b = (Math.pow(x, 2) / Math.pow(halfAxisX, 2)) - 1;
                double c = 0;
                double d = Math.pow(b, 2) - 4 * a * c;

                int y1 = (int) Math.round(-b + Math.sqrt(d) / (2 * a));
                int y2 = (int) Math.round(-b - Math.sqrt(d) / (2 * a));
                Screen.setPoint(x + centerX, y1 + centerY);
                Screen.setPoint(x + centerX, y2 + centerY);
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Ellipse with center in (%d, %d), x half-axis length = %d and y half-axis length = %d.",
                centerX, centerY, halfAxisX, halfAxisY);
    }

    @Override
    public double perimeter() {
        return (double) 4 * (Math.PI * halfAxisX * halfAxisY + (halfAxisX - halfAxisY)) / (halfAxisX + halfAxisY);
    }

    @Override
    public double area() {
        return Math.PI * halfAxisX * halfAxisY;
    }

    public Ellipse(int centerX, int centerY, int lengthX, int lengthY) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.halfAxisX = lengthX;
        this.halfAxisY = lengthY;
    }

    public int getCenterX() {
        return centerX;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public int getHalfAxisX() {
        return halfAxisX;
    }

    public void setHalfAxisX(int halfAxisX) {
        this.halfAxisX = halfAxisX;
    }

    public int getHalfAxisY() {
        return halfAxisY;
    }

    public void setHalfAxisY(int halfAxisY) {
        this.halfAxisY = halfAxisY;
    }
}