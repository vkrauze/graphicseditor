package com.vkrauze.graphicseditor.display;

import com.vkrauze.graphicseditor.figure.*;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;

public class TextModeDisplay extends Display {
    private int screenWidth = 120;
    private int screenHeight = 40;

    private static final char SET_PIXEL = '*';      // set IntelliJ console font to Courier to see this symbol properly
    private static final char CLEAR_PIXEL = ' ';
    private static final char BORDER_PIXEL = '+';

    private char[][] pixels;

    private OutputStream outputStream = System.out;

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    @Override
    public void render() {
        pixels = new char[screenHeight][screenWidth];
        clear();
        for (GeometricFigure figure : figures)
            if (figure instanceof Point)
                renderPoint((Point) figure);
            else if (figure instanceof Line)
                renderLine((Line) figure);
            else if (figure instanceof Rectangle)
                renderRectangle((Rectangle) figure);
            else if (figure instanceof Ellipse)
                renderEllipse((Ellipse) figure);
        show();
    }

    private void clear() {
        for (char[] line : pixels)
            Arrays.fill(line, CLEAR_PIXEL);
    }

    private void renderPoint(Point point) {
        setPixel(point.getX(), point.getY());
    }

    private void renderLine(Line line) {
        int x1 = line.getEnds().get(0).getX();
        int y1 = line.getEnds().get(0).getY();
        int x2 = line.getEnds().get(1).getX();
        int y2 = line.getEnds().get(1).getY();

        if (x1 != x2) {
            float slope = ((float) y2 - y1) / (x2 - x1);
            int smallerX = Math.min(x1, x2);
            int largerX = Math.max(x1, x2);
            for (int x = smallerX; x <= largerX; x++) {
                int y = (int) (slope * (x - x1) + y1);
                setPixel(x, y);
            }
        } else {
            int smallerY = Math.min(y1, y2);
            int largerY = Math.max(y1, y2);
            for (int y = smallerY; y <= largerY; y++) {
                setPixel(x1, y);
            }
        }
    }

    private void renderRectangle(Rectangle rectangle) {
        for (Line line : rectangle.getEdges())
            renderLine(line);
    }

    private void renderEllipse(Ellipse ellipse) {
        int halfAxisX = ellipse.getHalfAxisX();
        int halfAxisY = ellipse.getHalfAxisY();
        int centerX = ellipse.getCenterX();
        int centerY = ellipse.getCenterY();

        for (int x = -halfAxisX; x <= +halfAxisX; x++) {
            if (x == -halfAxisX || x == +halfAxisX)
                setPixel(x + centerX, centerY);
            else {
                int y = (int) Math.round(Math.sqrt(
                        Math.pow(halfAxisY, 2) * (1 - Math.pow(x, 2) / Math.pow(halfAxisX, 2))
                ));
                int y1 = +y;
                int y2 = -y;
                setPixel(x + centerX, y1 + centerY);
                setPixel(x + centerX, y2 + centerY);
            }
        }
    }

    private void setPixel(int x, int y) {
        if ((x < 0) || (x >= screenWidth))
            throw new RuntimeException(String.format("Wrong X value '%d', must be between 0 and %d inclusive.", x, screenWidth - 1));
        if ((y < 0) || (y >= screenHeight))
            throw new RuntimeException(String.format("Wrong Y value '%d', must be between 0 and %d inclusive.", y, screenHeight - 1));
        pixels[y][x] = SET_PIXEL;
    }

    private void show() {
        String horizontalLine = String.join("", Collections.nCopies(screenWidth + 2, String.valueOf(BORDER_PIXEL)));
        PrintStream printStream = new PrintStream(outputStream);
        printStream.println(horizontalLine);
        for (int y = screenHeight - 1; y >= 0; y--)
            printStream.println(BORDER_PIXEL + new String(pixels[y]) + BORDER_PIXEL);
        printStream.println(horizontalLine);
    }
}
