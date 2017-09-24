package com.vkrauze.graphicseditor.display;

import com.vkrauze.graphicseditor.figure.GeometricFigure;

import java.util.List;

public interface Display {
    void render(List<GeometricFigure> figures);
}
