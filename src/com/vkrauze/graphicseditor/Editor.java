package com.vkrauze.graphicseditor;

public class Editor {

    private static void line(int x1, int y1, int x2, int y2) {
        float slope = ((float) y2 - y1) / (x2 - x1);
        int smallerX = Math.min(x1, x2);
        int largerX = Math.max(x1, x2);
        for (int x = smallerX; x <= largerX; x++) {
            int y = (int) ( slope * (x - x1) + y1 );
            ScreenContents.setPoint(x, y);
        }
    }

    public static void main(String[] args) {
//        for (int x = 0; x < 80; x++) {
//            ScreenContents.setPoint(x, 0);
//        }
        line(0,0, 79, 24);
        ScreenContents.draw();
    }
}
