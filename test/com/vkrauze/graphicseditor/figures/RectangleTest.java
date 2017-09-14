package com.vkrauze.graphicseditor.figures;

import com.vkrauze.graphicseditor.figures.Ellipse;
import com.vkrauze.graphicseditor.figures.Rectangle;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleTest {

    @Test
    public void areaOfTwoByTwoRectangleIsRight() {
        Rectangle rectangle = new Rectangle(0, 0, 2, 2);


        Ellipse ellipse = new Ellipse(0, 0, 1, 1);
        double expectedArea = 3.14;
        double roundingDelta = 0.01;

        double area = ellipse.area();

        Assert.assertEquals("Calculated area must be right up to rounding delta", expectedArea, area, roundingDelta);
    }

    @Test
    public void perimeterOfTwoByTwoEllipseIsRight() {
        Ellipse ellipse = new Ellipse(0, 0, 1, 1);
        double expectedPerimeter = 6.28;
        double roundingDelta = 0.01;

        double perimeter = ellipse.perimeter();

        Assert.assertEquals("Calculated perimeter must be right up to rounding delta",
                expectedPerimeter, perimeter, roundingDelta);
    }
}
