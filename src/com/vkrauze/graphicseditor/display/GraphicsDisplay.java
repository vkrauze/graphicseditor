package com.vkrauze.graphicseditor.display;

import com.vkrauze.graphicseditor.figure.*;
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
            DrawCanvas canvas = new DrawCanvas();    // Construct the drawing canvas
            canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
            // Set the Drawing JPanel as the JFrame's content-pane
            Container cp = getContentPane();
            cp.add(canvas);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);   // Handle the CLOSE button
            pack();              // Either pack() the components; or setSize()
            setVisible(true);    // "super" JFrame show
        });
/*
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // set up the GUI components and event handlers
                DrawCanvas canvas = new DrawCanvas();    // Construct the drawing canvas
                canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
                // Set the Drawing JPanel as the JFrame's content-pane
                Container cp = getContentPane();
                cp.add(canvas);
                setDefaultCloseOperation(EXIT_ON_CLOSE);   // Handle the CLOSE button
                pack();              // Either pack() the components; or setSize()
                setVisible(true);    // "super" JFrame show
            }
        });
*/
    }

    @Override
    public void addFigure(GeometricFigure figure) {
        figures.add(figure);
    }

    @Override
    public void setFigures(List<GeometricFigure> figures) {
        this.figures = figures;
    }

    public GraphicsDisplay() {
    }

    /**
     * Define inner class DrawCanvas, which is a JPanel used for custom drawing.
     */
    private class DrawCanvas extends JPanel {
        // Override paintComponent to perform your own painting
        Graphics graphics;

        @Override
        public void paintComponent(Graphics graphics) {
            this.graphics = graphics;

            super.paintComponent(graphics);     // paint parent's background
            setBackground(Color.BLACK);  // set background color for this JPanel
            graphics.setColor(Color.WHITE);

            for (GeometricFigure figure : figures)
                if (figure instanceof Point)
                    renderPoint((Point) figure);
                else if (figure instanceof Line)
                    renderLine((Line) figure);
                else if (figure instanceof Rectangle)
                    renderRectangle((Rectangle) figure);
                else if (figure instanceof Ellipse)
                    renderEllipse((Ellipse) figure);
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

        private int convertToYFromTop(int y) {
            return CANVAS_HEIGHT - y;
        }
    }
}
