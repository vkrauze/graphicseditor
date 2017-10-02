package com.vkrauze.graphicseditor.display;

import com.vkrauze.graphicseditor.figure.GeometricFigure;
import com.vkrauze.graphicseditor.figure.Line;
import org.junit.Ignore;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class GraphicsDataTest {
    private BufferedImage image;
    private int imageWidth;
    private int imageHeight;

    @Test
    @Ignore("GraphicDisplay is undergoing development with animation implementation")
    public void testLineOutputIsRight() {
        imageWidth = 3;
        imageHeight = 4;
        image = getImage();
        GraphicsData graphicsData = new GraphicsData(getFiguresWithLine());
        graphicsData.setCanvasWidth(imageWidth);
        graphicsData.setCanvasHeight(imageHeight);

        graphicsData.processFigures(image.getGraphics());

        Color[] expectedPixels = getExpectedPixels();
        Color[] actualPixels = getActualPixels();
        assertEquals("Lengths of arrays must be equal", expectedPixels.length, actualPixels.length);
        assertArrayEquals("Arrays must be equal", expectedPixels, actualPixels);
    }

    // By default, background color is black and painting color is white
    private Color[] getExpectedPixels() {
        return new Color[]{BLACK, BLACK, BLACK,
                BLACK, BLACK, WHITE,
                BLACK, WHITE, BLACK,
                WHITE, BLACK, BLACK};
    }

    private Color[] getActualPixels() {
        int[] actualRGB = image.getRGB(0, 0, imageWidth, imageHeight, null, 0, imageWidth);
        return IntStream.of(actualRGB)
                .mapToObj(Color::new)
                .collect(Collectors.toList())
                .toArray(new Color[]{});
    }

    private java.util.List<GeometricFigure> getFiguresWithLine() {
        return Collections.singletonList(new Line(0, 1, 2, 3));
    }

    private BufferedImage getImage() {
        return new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
    }
}
