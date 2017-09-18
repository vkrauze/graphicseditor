package com.vkrauze.graphicseditor.display;

import com.vkrauze.graphicseditor.figure.GeometricFigure;
import com.vkrauze.graphicseditor.figure.Point;
import com.vkrauze.graphicseditor.figure.Line;
import com.vkrauze.graphicseditor.figure.Rectangle;
import com.vkrauze.graphicseditor.figure.Ellipse;

import java.awt.*;       // Using AWT's Graphics and Color
import java.awt.event.*; // Using AWT event classes and listener interfaces
import javax.swing.*;    // Using Swing's components and containers

public class GraphicsDisplay extends Display {
    private static final int CANVAS_WIDTH = 640;
    private static final int CANVAS_HEIGHT = 480;

    @Override
    public void render() {
        // Run the GUI codes on the Event-Dispatching thread for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CGTemplate(); // Let the constructor do the job
            }
        });
    }

    /**
     * Custom Drawing Code Template
     */
    // A Swing application extends javax.swing.JFrame
    private class CGTemplate extends JFrame {
        // Define constants
/*        public static final int CANVAS_WIDTH = 640;
        public static final int CANVAS_HEIGHT = 480;*/

        // Declare an instance of the drawing canvas,
        // which is an inner class called DrawCanvas extending javax.swing.JPanel.
        private DrawCanvas canvas;

        // Constructor to set up the GUI components and event handlers
        CGTemplate() {
            canvas = new DrawCanvas();    // Construct the drawing canvas
            canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
            // Set the Drawing JPanel as the JFrame's content-pane
            Container cp = getContentPane();
            cp.add(canvas);
            // or "setContentPane(canvas);"
            setDefaultCloseOperation(EXIT_ON_CLOSE);   // Handle the CLOSE button
            pack();              // Either pack() the components; or setSize()
//            setTitle("......");  // "super" JFrame sets the title
            setVisible(true);    // "super" JFrame show
        }
    }

    /**
     * Define inner class DrawCanvas, which is a JPanel used for custom drawing.
     */
    private class DrawCanvas extends JPanel {
        // Override paintComponent to perform your own painting
        Graphics g;

        @Override
        public void paintComponent(Graphics g) {
            this.g = g;

            super.paintComponent(g);     // paint parent's background
            setBackground(Color.BLACK);  // set background color for this JPanel
            // Your custom painting codes. For example,
            // Drawing primitive shapes
/*            g.setColor(Color.YELLOW);    // set the drawing color
            g.drawLine(30, 40, 100, 200);
            g.drawOval(150, 180, 10, 10);
            g.drawRect(200, 210, 20, 30);
            g.setColor(Color.RED);       // change the drawing color
            g.fillOval(300, 310, 30, 50);
            g.fillRect(400, 350, 60, 50);
            // Printing texts
            g.setColor(Color.WHITE);
            g.setFont(new Font("Monospaced", Font.PLAIN, 12));
            g.drawString("Testing custom drawing ...", 10, 20);*/
            g.setColor(Color.WHITE);

            for (GeometricFigure figure : figures)
                if (figure instanceof Point)
                    drawPoint((Point) figure);
                else if (figure instanceof Line)
                    renderLine((Line) figure);
                else if (figure instanceof Rectangle)
                    renderRectangle((Rectangle) figure);
                else if (figure instanceof Ellipse)
                    renderEllipse((Ellipse) figure);

        }

        private void renderEllipse(Ellipse figure) {
        }

        private void renderRectangle(Rectangle figure) {
        }

        private void renderLine(Line line) {
            Point point1 = line.getEnds().get(0);
            Point point2 = line.getEnds().get(1);

            g.drawLine(point1.getX(), CANVAS_HEIGHT - point1.getY(), point2.getX(), CANVAS_HEIGHT - point2.getY());
        }

        private void drawPoint(Point figure) {
        }
    }

/*    // The entry main method
    public static void main(String[] args) {
        // Run the GUI codes on the Event-Dispatching thread for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CGTemplate(); // Let the constructor do the job
            }
        });
    }*/
}
