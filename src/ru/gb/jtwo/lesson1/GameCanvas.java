package ru.gb.jtwo.lesson1;

import javax.swing.*;
import java.awt.*;
//user import, update, render
public class GameCanvas extends JPanel {

    MainCircles gameController;
    private long lastFramrTime;

    public GameCanvas(MainCircles gameController) {
        this.gameController = gameController;
        lastFramrTime = System.nanoTime();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFramrTime) * 0.000000001f;
        lastFramrTime= currentTime;
        gameController.onDrownFrame(this, g, deltaTime);
        try {
            Thread.sleep(17);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        repaint();
    }

    public int getLeft() {return  0;}
    public int getRigth() {return getWidth() - 1;}
    public int getTop() {return 0;}
    public int getBottom() {return getHeight() - 1;}
}