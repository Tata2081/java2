package ru.gb.jtwo.lesson1;

import java.awt.*;

public class Background extends Sprite {
    private final float vTime = (float) (Math.random() * 10f);
    private long lastFramrTime;

    Background(GameCanvas canvas) {
        Color color =  new Color(
                (int) (Math.random() * 255),
                (int) (Math.random() * 255),
                (int) (Math.random() * 255));
        canvas.setBackground(color);
        lastFramrTime = System.nanoTime();
    }

    @Override
    void updade(GameCanvas canvas, float deltaTime) {
        long currentTime = System.nanoTime();
        float changeTime = (currentTime - lastFramrTime) * 0.000000001f;
        if (changeTime > vTime ) {
            Color color =  new Color(
                    (int) (Math.random() * 255),
                    (int) (Math.random() * 255),
                    (int) (Math.random() * 255));

            canvas.setBackground(color);

            lastFramrTime= currentTime;
        }
    }
}