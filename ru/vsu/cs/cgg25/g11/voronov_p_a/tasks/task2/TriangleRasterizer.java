package ru.vsu.cs.cgg25.g11.voronov_p_a.tasks.task2;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TriangleRasterizer extends JPanel {
    private static Point a;
    private static Point b;
    private static Point c;
    private static Color c1;
    private static Color c2;
    private static Color c3;

    public static void launch(Point a, Point b, Point c, Color cr) {
        launch(a, b, c, cr, cr, cr);
    }

    public static void launch(Point al, Point bl, Point cl, Color c1l, Color c2l, Color c3l) {
        a = al;
        b = bl;
        c = cl;
        c1 = c1l;
        c2 = c2l;
        c3 = c3l;
        JFrame frame = new JFrame("Triangle Rasterization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TriangleRasterizer());
        frame.pack();
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        rasterizeTriangle(g);
    }

    public void rasterizeTriangle(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                double[] baryCoords = calculateBaryCoords(new Point(x, y), a, b, c);
                if (isInsideTriangle(baryCoords)) {
                    Color interpolatedColor = interpolateColor(baryCoords, c1, c2, c3);
                    g.setColor(interpolatedColor);
                    g.fillRect(x, y, 1, 1);
                }
            }
        }
    }

    private double[] calculateBaryCoords(Point p, Point a, Point b, Point c) {
        double areaTotal = triangleArea(a, b, c);
        double areaA = triangleArea(p, b, c) / areaTotal;
        double areaB = triangleArea(a, p, c) / areaTotal;
        double areaC = triangleArea(a, b, p) / areaTotal;
        return new double[]{areaA, areaB, areaC};
    }

    private float triangleArea(Point a, Point b, Point c) {
        return abs((a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y))) / 2f;
    }

    private float abs(float x) {
        if (x < 0) {
            return -x;
        } else {
            return x;
        }
    }

    private boolean isInsideTriangle(double[] baryCoords) {
        return baryCoords[0] >= 0 && baryCoords[1] >= 0 && baryCoords[2] >= 0 &&
                baryCoords[0] + baryCoords[1] + baryCoords[2] <= 1 + 1e-7;
    }

    private Color interpolateColor(double[] baryCoords, Color c1, Color c2, Color c3) {
        int red = (int) (c1.getRed() * baryCoords[0] +
                c2.getRed() * baryCoords[1] +
                c3.getRed() * baryCoords[2]);

        int green = (int) (c1.getGreen() * baryCoords[0] +
                c2.getGreen() * baryCoords[1] +
                c3.getGreen() * baryCoords[2]);

        int blue = (int) (c1.getBlue() * baryCoords[0] +
                c2.getBlue() * baryCoords[1] +
                c3.getBlue() * baryCoords[2]);

        return new Color(red, green, blue);
    }
}