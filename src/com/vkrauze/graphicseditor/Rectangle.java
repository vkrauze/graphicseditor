package com.vkrauze.graphicseditor;

import java.util.List;

public class Rectangle implements GeometricFigure {
    private List<Line> edges;

    @Override
    public String toString() {
        edges.stream().flatMap()

        return super.toString();
    }

    @Override
    public Integer perimeter() {
        return null;
    }

    @Override
    public Integer area() {
        return null;
    }

    public List<Line> getEdges() {
        return edges;
    }

    public void setEdges(List<Line> edges) {
        this.edges = edges;
    }
}
