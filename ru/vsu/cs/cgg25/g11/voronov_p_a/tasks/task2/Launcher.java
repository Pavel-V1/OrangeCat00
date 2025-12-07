package ru.vsu.cs.cgg25.g11.voronov_p_a.tasks.task2;

import java.awt.*;

public class Launcher {
    public static void main(String[] args) {
        Point a = new Point(10, 10);
        Point b = new Point(200, 200);
        Point c = new Point(1200, 500);
        Color c1 = new Color(255, 128, 0);
        Color c2 = Color.BLACK;
        Color c3 = Color.GRAY;

        TriangleRasterizer.launch(a, b, c, c1, c2, c3);
    }
}
