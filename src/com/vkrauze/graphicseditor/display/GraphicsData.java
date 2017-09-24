package com.vkrauze.graphicseditor.display;

import com.vkrauze.graphicseditor.figure.Ellipse;
import com.vkrauze.graphicseditor.figure.GeometricFigure;
import com.vkrauze.graphicseditor.figure.Line;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class GraphicsData {
    private java.util.List<GeometricFigure> figures = new ArrayList<>();

    private Graphics graphics;

    private int canvasWidth = 640;
    private int canvasHeight = 480;

    GraphicsData(List<GeometricFigure> figures) {
        this.figures = figures;
    }

    void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    void setCanvasWidth(int canvasWidth) {
        this.canvasWidth = canvasWidth;
    }

    void setCanvasHeight(int canvasHeight) {
        this.canvasHeight = canvasHeight;
    }

    void processFigures() {
        for (GeometricFigure figure : figures)
            if (figure instanceof com.vkrauze.graphicseditor.figure.Point)
                renderPoint((com.vkrauze.graphicseditor.figure.Point) figure);
            else if (figure instanceof Line)
                renderLine((Line) figure);
            else if (figure instanceof com.vkrauze.graphicseditor.figure.Rectangle)
                renderRectangle((com.vkrauze.graphicseditor.figure.Rectangle) figure);
            else if (figure instanceof Ellipse)
                renderEllipse((Ellipse) figure);
    }

    private void renderPoint(com.vkrauze.graphicseditor.figure.Point p) {
        int pX = p.getX();
        int pY = convertToYFromTop(p.getY());
        graphics.fillRect(pX, pY, 1, 1);
    }

    private void renderLine(Line line) {
        com.vkrauze.graphicseditor.figure.Point p1 = line.getEnds().get(0);
        com.vkrauze.graphicseditor.figure.Point p2 = line.getEnds().get(1);
        graphics.drawLine(p1.getX(), convertToYFromTop(p1.getY()), p2.getX(), convertToYFromTop(p2.getY()));
    }

    private void renderRectangle(com.vkrauze.graphicseditor.figure.Rectangle rectangle) {
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

    private int convertToYFromTop(int y) {
        return canvasHeight - y;
    }
}
