package ru.vsu.cs.cgg25.g11.voronov_p_a.tasks;

import javax.swing.*;
import java.awt.*;

class ApplicationPanel extends JPanel {
    private float renderingTime = 0.0f;

    private float rectPositionX = 0;
    private float rectPositionY = 100;
    private float rectPositionY2 = 250;
    private float rectWidth = 200;
    private float rectHeight = 100;

    private float ovalPositionX = 250;
    private float ovalPositionY = 340;
    private float ovalWidth = 100;
    private float ovalHeight = 100;

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

//        ovalPositionX += AnimationSpeed * ovalAnimationDirectionX * timeDelta;
        ovalPositionX = rectPositionY + 120;
        ovalPositionY = getHeight() - ovalHeight;
        rectPositionY += AnimationSpeed * rectAnimationDirectionY * timeDelta;
        rectPositionY2 = getHeight() - rectHeight - rectPositionY;

        if (ovalPositionX < getWidth() * 0.2 || ovalPositionX + ovalWidth > getWidth() / 1.2) {
            ovalAnimationDirectionX *= -1;
        }

        if (rectPositionY < 0 || rectPositionY + rectHeight > getHeight()) {
            rectAnimationDirectionY *= -1;
        }

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

        g.setColor(new Color(46, 44, 44));
        g.fillRect((int) rectPositionX,
                (int) rectPositionY,
                (int) rectWidth,
                (int) rectHeight);
        g.fillRect((int) rectPositionX + 370,
                (int) rectPositionY2,
                (int) rectWidth,
                (int) rectHeight);
        g.setColor(Color.RED);
        g.fillOval((int) ovalPositionX,
                (int) ovalPositionY,
                (int) ovalWidth,
                (int) ovalHeight);
        g.setColor(Color.WHITE);
        g.fillOval((int) ovalPositionX + 20,
                (int) ovalPositionY + 20,
                (int) ovalWidth / 5,
                (int) ovalHeight / 5);
        g.fillOval((int) ovalPositionX + 60,
                (int) ovalPositionY + 20,
                (int) ovalWidth / 5,
                (int) ovalHeight / 5);
        g.setColor(Color.BLACK);
        g.fillOval((int) ovalPositionX + 27,
                (int) ovalPositionY + 27,
                (int) ovalWidth / 17,
                (int) ovalHeight / 17);
        g.fillOval((int) ovalPositionX + 67,
                (int) ovalPositionY + 27,
                (int) ovalWidth / 17,
                (int) ovalHeight / 17);
        g.drawArc((int) ovalPositionX + 30,
                (int) ovalPositionY + 50,
                40,
                20,
                190,
                170);
        g.fillRect((int) rectPositionX + (int) rectWidth / 4,
                0,
                (int) rectWidth / 2,
                (int) rectPositionY);
        g.fillRect((int) rectPositionX + (int) rectWidth / 4 + 370,
                0,
                (int) rectWidth / 2,
                (int) rectPositionY2);
        g.setColor(currentColor);
        g.drawString("RED BALL", 260, 100);
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
