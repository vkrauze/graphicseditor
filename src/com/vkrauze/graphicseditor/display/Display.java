package com.vkrauze.graphicseditor.display;

import com.vkrauze.graphicseditor.figure.GeometricFigure;

import java.util.ArrayList;
import java.util.List;

public abstract class Display {
    List<GeometricFigure> figures = new ArrayList<>();

    public abstract void render();

    public void addFigure(GeometricFigure figure) {
        figures.add(figure);
    }

    public void removeFigure(GeometricFigure figure) {
        figures.remove(figure);
    }

    public void clearFigures() {
        figures.clear();
    }

    public List<GeometricFigure> getFigures() {
        return figures;
    }

    public void setFigures(List<GeometricFigure> figures) {
        this.figures = figures;
    }
}
