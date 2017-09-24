package com.vkrauze.graphicseditor.display;

import com.vkrauze.graphicseditor.figure.*;
import com.vkrauze.graphicseditor.figure.Point;
import com.vkrauze.graphicseditor.figure.Rectangle;

import java.awt.*;
import java.util.List;

class GraphicsData {
    private java.util.List<GeometricFigure> figures;

    private Graphics graphics;

    private int canvasWidth = 640;
    private int canvasHeight = 480;

    GraphicsData(List<GeometricFigure> figures) {
        this.figures = figures;
    }

    void setCanvasWidth(int canvasWidth) {
        this.canvasWidth = canvasWidth;
    }

    void setCanvasHeight(int canvasHeight) {
        this.canvasHeight = canvasHeight;
    }

    void processFigures(Graphics graphics) {
        this.graphics = graphics;
        for (GeometricFigure figure : figures)
            if (figure instanceof Point)
                renderPoint((Point) figure);
            else if (figure instanceof Line)
                renderLine((Line) figure);
            else if (figure instanceof Rectangle)
                renderRectangle((Rectangle) figure);
            else if (figure instanceof Ellipse)
                renderEllipse((Ellipse) figure);
            else
                throw new RuntimeException("Got figure of unknown type: " + figure.toString());
    }

    private void renderPoint(Point p) {
        int pX = p.getX();
        int pY = convertToYFromTop(p.getY());
        graphics.fillRect(pX, pY, 1, 1);
    }

    private void renderLine(Line line) {
        Point p1 = line.getEnds().get(0);
        Point p2 = line.getEnds().get(1);
        graphics.drawLine(p1.getX(), convertToYFromTop(p1.getY()), p2.getX(), convertToYFromTop(p2.getY()));
    }

    private void renderRectangle(Rectangle rectangle) {
        for (Line line : rectangle.getEdges())
            renderLine(line);
    }

    private void renderEllipse(Ellipse ellipse) {
        int ellipseTopLeftX = ellipse.getCenterX() - ellipse.getHalfAxisX();
        int ellipseTopLeftY = ellipse.getCenterY() + ellipse.getHalfAxisY();
        int width = ellipse.getHalfAxisX() * 2;
        int height = ellipse.getHalfAxisY() * 2;
        graphics.drawOval(ellipseTopLeftX, convertToYFromTop(ellipseTopLeftY), width, height);
    }

    // From bottom-based Y-coordinate of this application to top-based Y of AWT
    private int convertToYFromTop(int y) {
        return canvasHeight - y;
    }
}
