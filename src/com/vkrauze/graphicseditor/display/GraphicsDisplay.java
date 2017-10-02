package com.vkrauze.graphicseditor.display;

import com.vkrauze.graphicseditor.figure.GeometricFigure;
import com.vkrauze.graphicseditor.figure.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * A Swing application extends javax.swing.JFrame
 */
public class GraphicsDisplay extends JFrame implements Display {
    private java.util.List<GeometricFigure> figures;

    private static final int CANVAS_WIDTH = 640;
    private static final int CANVAS_HEIGHT = 480;

    @Override
    public void render(List<GeometricFigure> figures) {
        this.figures = figures;
        // Run the GUI codes on the Event-Dispatching thread for thread safety
        SwingUtilities.invokeLater(() -> {
            // Set up the GUI components and event handlers
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

    /**
     * Define inner class GraphicsCanvas, which is a JPanel used for custom drawing.
     */
    private class GraphicsCanvas extends JPanel {
        Graphics graphics;

        GraphicsCanvas() {
            Timer timer = new Timer(40, e -> repaint());
            timer.start();
        }

        private void movePoint(Point point) {
            if (point.getY() > CANVAS_HEIGHT)
                point.setY(0);
            else
                point.setY(point.getY() + 1);
        }

        // Override paintComponent to perform your own painting
        @Override
        public void paintComponent(Graphics passedGraphics) {
            this.graphics = passedGraphics;

            super.paintComponent(graphics);     // paint parent's background
            setBackground(Color.BLACK);     // set background color for this JPanel
            graphics.setColor(Color.WHITE);

            GraphicsData graphicsData = new GraphicsData(figures);

            movePoint((Point) figures.get(7));
            movePoint((Point) figures.get(8));

            graphicsData.setCanvasWidth(CANVAS_WIDTH);
            graphicsData.setCanvasHeight(CANVAS_HEIGHT);
            graphicsData.processFigures(graphics);
        }
    }
}
