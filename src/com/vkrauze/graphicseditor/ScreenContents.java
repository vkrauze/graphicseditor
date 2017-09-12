package com.vkrauze.graphicseditor;

public class ScreenContents {
    public static final int SCREEN_WIDTH = 80;
    public static final int SCREEN_HEIGHT = 25;
    private static final char SET_PIXEL = 0x2588;

    private static char[][] pixels = new char[SCREEN_HEIGHT][SCREEN_WIDTH];

    public static void setPoint(int x, int y) {
        assert x < SCREEN_WIDTH : "X too big";
        assert y < SCREEN_HEIGHT : "Y too big";
        pixels[y][x] = SET_PIXEL;
    }

    public static void draw() {
        for(int y = 0; y < SCREEN_HEIGHT; y++) {
            System.out.println(new String(pixels[y]));
    }
    }
}
