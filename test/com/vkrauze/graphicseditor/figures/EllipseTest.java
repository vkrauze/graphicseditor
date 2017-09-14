package com.vkrauze.graphicseditor.figures;

import org.junit.Assert;
import org.junit.Test;

public class EllipseTest {

    @Test
    public void areaOfTwoByTwoEllipseIsRight() {
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
