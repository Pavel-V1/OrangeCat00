package ru.vsu.cs.cgg25.g11.voronov_p_a.tasks.task2;

import javax.swing.*;
import java.awt.*;

class ApplicationPanel extends JPanel {
    private Color c1;
    private Color c2;
    private Color c3;
    private Point p1;
    private Point p2;
    private Point p3;

    public void setTriangle(Point point1, Point point2, Point point3, Color colorForPoint1, Color colorForPoint2, Color colorForPoint3) {
        p1 = point1;
        p2 = point2;
        p3 = point3;
        c1 = colorForPoint1;
        c2 = colorForPoint2;
        c3 = colorForPoint3;
    }

    public ApplicationPanel(boolean blackTheme) {
        if (blackTheme) {
            setBackground(new Color(0, 0, 0));
        } else {
            setBackground(new Color(255, 255, 255));
        }
    }

//    public void update() {
//        currentColor = new Color(
//                (int) triangleInterpolation(
//                        startColor.getRed(), finishColor.getRed(), sinValueRemapped),
//                (int) triangleInterpolation(
//                        startColor.getGreen(), finishColor.getGreen(), sinValueRemapped),
//                (int) triangleInterpolation(
//                        startColor.getBlue(), finishColor.getBlue(), sinValueRemapped));
//    }

    public void triangleInterpolation(Point p1, Point p2, Point p3) {
        float x1 = p1.x;
        float x2 = p2.x;
        float x3 = p3.x;
        float y1 = p1.y;
        float y2 = p2.y;
        float y3 = p3.y;


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        triangle(g, p1, c1, p2, c2, p3, c3);
    }

    private void triangle(Graphics g, Point p1, Color c1, Point p2, Color c2, Point p3, Color c3) {
        //
    }
}

class ApplicationWindow extends JFrame {
    public ApplicationWindow() {
        setTitle("Task 2");
        setPreferredSize(new Dimension(640, 480));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(new Point(1920 / 2 - 640 / 2, 1080 / 2 - 480 / 2));

        ApplicationPanel panel = new ApplicationPanel(true);
        getContentPane().add(panel);

        pack();
    }
}

public class myApplication {
    public static void applicationPush() {
        ApplicationWindow applicationWindow = new ApplicationWindow();
        applicationWindow.setVisible(true);
    }
}
