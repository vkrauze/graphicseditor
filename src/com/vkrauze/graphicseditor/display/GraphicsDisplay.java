package com.vkrauze.graphicseditor.display;

import com.vkrauze.graphicseditor.figure.Ellipse;
import com.vkrauze.graphicseditor.figure.GeometricFigure;
import com.vkrauze.graphicseditor.figure.Line;
import com.vkrauze.graphicseditor.figure.Point;
import com.vkrauze.graphicseditor.figure.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Custom Drawing Code Template
 */
// A Swing application extends javax.swing.JFrame
public class GraphicsDisplay extends JFrame implements Display {
    private java.util.List<GeometricFigure> figures = new ArrayList<>();

    private static final int CANVAS_WIDTH = 640;
    private static final int CANVAS_HEIGHT = 480;

    @Override
    public void render() {
        // Run the GUI codes on the Event-Dispatching thread for thread safety
        SwingUtilities.invokeLater(() -> {
            // set up the GUI components and event handlers
            GraphicsCanvas canvas = new GraphicsCanvas();    // Construct the drawing canvas
            canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
            // Set the Drawing JPanel as the JFrame's content-pane
            Container cp = getContentPane();
            cp.add(canvas);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);   // Handle the CLOSE button
            pack();              // Either pack() the components; or setSize()
            setVisible(true);    // "super" JFrame show
        });
    }

    @Override
    public void addFigure(GeometricFigure figure) {
        figures.add(figure);
    }

    @Override
    public void setFigures(List<GeometricFigure> figures) {
        this.figures = figures;
    }

    /**
     * Define inner class GraphicsCanvas, which is a JPanel used for custom drawing.
     */
    private class GraphicsCanvas extends JPanel {
        // Override paintComponent to perform your own painting
        Graphics graphics;

        @Override
        public void paintComponent(Graphics passedGraphics) {
            this.graphics = passedGraphics;

            super.paintComponent(graphics);     // paint parent's background
            setBackground(Color.BLACK);  // set background color for this JPanel
            graphics.setColor(Color.WHITE);

            GraphicsData graphicsData = new GraphicsData(figures);
            graphicsData.setGraphics(graphics);
            graphicsData.setCanvasWidth(CANVAS_WIDTH);
            graphicsData.setCanvasHeight(CANVAS_HEIGHT);
            graphicsData.processFigures();
        }

    }
}
