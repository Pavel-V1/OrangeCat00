package ru.vsu.cs.cgg25.g11.voronov_p_a.tasks.task2;

import java.awt.*;

public class Launcher {
    public static void main(String[] args) {
        Point a = new Point(30, 10);
        Point a1 = new Point(10, 10);
        Point b = new Point(250, 200);
        Point b1 = new Point(200, 200);
        Point c = new Point(1200, 500);
        Point d = new Point(120, 1100);
        Point p1 = new Point(350, 500);
        Point p2 = new Point(550, 500);
        Point p3 = new Point(450, 350);
        Color c1 = new Color(255, 128, 0);
        Color c2 = Color.BLACK;
        Color c3 = Color.GRAY;

        TriangleRasterizer.makeTriangle(a, b, c, c1, c2, c3);
        TriangleRasterizer.makeTriangle(a1, b1, d, c1);
        TriangleRasterizer.makeTriangle(p1, p2, p3, c2);
        TriangleRasterizer.makeTriangle(new Point(p1.x + 100, p1.y + 100),
                                        new Point(p2.x + 100, p2.y + 100),
                                        new Point(p3.x + 100, p3.y + 100), c3);
        TriangleRasterizer.makeBoxForTriangle(new Point(p1.x + 100, p1.y + 100),
                                              new Point(p2.x + 100, p2.y + 100),
                                              new Point(p3.x + 100, p3.y + 100), c1);
        TriangleRasterizer.makeTriangle(new Point(270, 270), new Point(270, 300), new Point(300, 350), Color.RED);
        TriangleRasterizer.launch();
    }
}
