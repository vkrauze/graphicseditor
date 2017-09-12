package com.vkrauze.graphicseditor;

public class Ellipse implements GeometricFigure{
    int centerX;
    int centerY;
    int halfAxisX;
    int halfAxisY;

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
