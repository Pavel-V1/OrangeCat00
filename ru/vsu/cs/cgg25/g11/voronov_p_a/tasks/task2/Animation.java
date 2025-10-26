package ru.vsu.cs.cgg25.g11.voronov_p_a.tasks.task2;

import javax.swing.*;
import java.awt.*;

class ApplicationPanel extends JPanel {
    private float renderingTime = 0.0f;

    private float AnimationSpeed = 100;
    private float ovalAnimationDirectionX = 1.0f;
    private float rectAnimationDirectionY = 1.0f;

    private Color startColor = new Color(255, 0, 0);

    private Color finishColor = new Color(23, 23, 23);

    private Color currentColor = startColor;

    public ApplicationPanel() {
        setBackground(new Color(6, 29, 60));
    }

    public void update(float timeDelta) {
        renderingTime += timeDelta;

        float sinValue = (float) Math.sin(renderingTime * 5.0f); // [-1, 1]
        float sinValueRemapped = (sinValue + 1.0f) / 2.0f; // [0, 1]

        currentColor = new Color(
                (int) linearInterpolation(
                        startColor.getRed(), finishColor.getRed(), sinValueRemapped),
                (int) linearInterpolation(
                        startColor.getGreen(), finishColor.getGreen(), sinValueRemapped),
                (int) linearInterpolation(
                        startColor.getBlue(), finishColor.getBlue(), sinValueRemapped));
    }

    public float linearInterpolation(float min, float max, float time) {
        return min + (max - min) * time;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        triangle(g, p1, c1, p2, c2, p3, c3);
    }

    private void triangle(Graphics g, Point p1, Color c1, Point p2, Color c2, Point p3, Color c3) {

    }
}

class ApplicationWindow extends JFrame {
    public ApplicationWindow() {
        setTitle("Task 1");
        setPreferredSize(new Dimension(640, 480));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(new Point(1920 / 2 - 640 / 2, 1080 / 2 - 480 / 2));

        ApplicationPanel panel = new ApplicationPanel();
        getContentPane().add(panel);

        pack();

        int applicationFPS = 30;

        Timer timer = new Timer(1000 / applicationFPS, event -> {
            panel.update(1.0f / applicationFPS);
            panel.repaint();
        });

        timer.start();
    }
}

public class Animation {
    public static void animationPush() {
        ApplicationWindow applicationWindow = new ApplicationWindow();
        applicationWindow.setVisible(true);
    }
}
