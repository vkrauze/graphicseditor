package com.vkrauze.graphicseditor.display;

import com.vkrauze.graphicseditor.figure.GeometricFigure;
import com.vkrauze.graphicseditor.figure.Line;
import com.vkrauze.graphicseditor.figure.Point;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TextModeDisplayTest {
    @Test
    public void testLineOutputIsRight() {
        String expected = getExpectedString();
        TextModeDisplay display = getTextModeDisplay();
        Line lineMock = createLineMock();

        display.render(Collections.singletonList(lineMock));

        OutputStream out = display.getOutputStream();
        byte[] outputBytes = ((ByteArrayOutputStream) out).toByteArray();
        String output = new String(outputBytes);

        assertEquals(expected, output);
    }

    private String getExpectedString() {
        String newLine = System.lineSeparator();
        return "" +
                "+++++" + newLine +
                "+  *+" + newLine +
                "+ * +" + newLine +
                "+*  +" + newLine +
                "+++++" + newLine;
    }

    private TextModeDisplay getTextModeDisplay() {
        TextModeDisplay display = new TextModeDisplay();
        OutputStream out = new ByteArrayOutputStream();
        display.setOutputStream(out);
        display.setCanvasHeight(3);
        display.setCanvasWidth(3);
        return display;
    }

    private Line createLineMock() {
        Point pointMock = mock(Point.class);
        when(pointMock.getX())
                .thenReturn(0)
                .thenReturn(2);
        when(pointMock.getY())
                .thenReturn(0)
                .thenReturn(2);

        Line lineMock = mock(Line.class);
        when(lineMock.getEnds())
                .thenReturn(Arrays.asList(pointMock, pointMock));
        return lineMock;
    }

    @Test
    public void testCallsMethodsOfFigures() {
        TextModeDisplay display = getTextModeDisplay();
        Line lineMock = createLineMock();

        display.render(Collections.singletonList(lineMock));

        verify(lineMock, times(4)).getEnds();
    }
}
