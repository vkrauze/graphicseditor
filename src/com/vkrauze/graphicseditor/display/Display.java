package com.vkrauze.graphicseditor.display;

import com.vkrauze.graphicseditor.figure.GeometricFigure;

import java.util.List;

public interface Display {
    void render();

    void addFigure(GeometricFigure figure);

    void setFigures(List<GeometricFigure> figures);
}
