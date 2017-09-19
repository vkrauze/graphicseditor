package com.vkrauze.graphicseditor.display;

import com.vkrauze.graphicseditor.figure.Line;
import com.vkrauze.graphicseditor.figure.Point;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TextModeDisplayTest {
    @Test
    public void lineOutputRight() {
        String expected = getExpectedString();
        TextModeDisplay display = getTextModeDisplay();
        Line lineMock = createLineMock();
        display.addFigure(lineMock);

        display.render();

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
        display.setScreenHeight(3);
        display.setScreenWidth(3);
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
}
