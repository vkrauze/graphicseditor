package com.vkrauze.graphicseditor.display;

import com.vkrauze.graphicseditor.figure.Line;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class GraphicsDataTest {

    @Test
    public void testLineOutputIsRight() {
        BufferedImage image = new BufferedImage(640, 480, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        GraphicsData graphicsData = new GraphicsData(Collections.singletonList(new Line(1, 1, 3, 3)));
        graphicsData.setCanvasWidth(4);
        graphicsData.setCanvasHeight(4);

        graphicsData.processFigures(graphics);

//        assertEquals(Color.WHITE, getColor(image, 0,0));
//        assertEquals(Color.BLACK, getColor(image, 1,0));
//        assertEquals(Color.BLACK, getColor(image, 2,0));

        int width = image.getWidth();
        int height = image.getHeight();

        int[] pixels = image.getRGB(0,0, width, height, null,0, width);
    }

    private Color getColor(BufferedImage image, int x, int y) {
        return new Color(image.getRGB(x,y));
    }

}
