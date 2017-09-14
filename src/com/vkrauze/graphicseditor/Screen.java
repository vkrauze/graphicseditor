package com.vkrauze.graphicseditor;

import java.util.Arrays;
import java.util.Collections;

public class Screen {
    public static final int SCREEN_WIDTH = 120;
    public static final int SCREEN_HEIGHT = 40;
//    private static final char SET_PIXEL = 0x2588;
    private static final char CLEAR_PIXEL = ' ';
    private static final char SET_PIXEL = '*';
    private static final char BORDER_PIXEL = '#';

    private static char[][] pixels = new char[SCREEN_HEIGHT][SCREEN_WIDTH];

    public static void clear() {
        for(char[] line : pixels)
            Arrays.fill(line, CLEAR_PIXEL);
    }

    public static void setPoint(int x, int y) {
        if ((x < 0) || (x >= SCREEN_WIDTH))
            throw new RuntimeException(String.format("Wrong X value '%d', must be between 0 and %d inclusive.", x, SCREEN_WIDTH - 1));
        if ((y < 0) || (y >= SCREEN_HEIGHT))
            throw new RuntimeException(String.format("Wrong Y value '%d', must be between 0 and %d inclusive.", y, SCREEN_HEIGHT - 1));
        pixels[y][x] = SET_PIXEL;
    }

    public static void show() {
//        for(int y = 0; y < SCREEN_HEIGHT; y++) {
        String horizontalLine = String.join("", Collections.nCopies(SCREEN_WIDTH + 2, String.valueOf(BORDER_PIXEL)));
        System.out.println(horizontalLine);
        for(int y = SCREEN_HEIGHT - 1; y >= 0; y--)
            System.out.println(BORDER_PIXEL + new String(pixels[y]) + BORDER_PIXEL);
        System.out.println(horizontalLine);
    }
}
