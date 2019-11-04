package ru.gb.jtwo.lesson1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class MainCircles extends JFrame {

    /*
     * Полностью разобраться с кодом
     * Прочитать методичку на следущий урок
     * Написать класс бэкгграунд изменющий цвет канвы изменяющий цвет взависимости от времени
     *  * Реализовать  добавление новых кружков по клику использовать только массивы
     * ** Реализовать по клику другой кнопки удаление кружков (никаких эррейлист)*/
    private static final int POS_X = 400;
    private static final int POS_Y = 100;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGTH = 600;
    private Sprite[] sprite = new Sprite[1];
    private Background bg;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }

    private  MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGTH);
        setTitle("Circles");

        GameCanvas canvas = new GameCanvas(this);
        add(canvas, BorderLayout.CENTER);
        initApplication(canvas);

        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    sprite = Arrays.copyOf(sprite, sprite.length + 1);
                    sprite[sprite.length - 1] = new Ball();
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    if (sprite.length > 0) {
                        sprite[sprite.length - 1] = null;
                        sprite = Arrays.copyOf(sprite, sprite.length - 1);
                    }
                }
            }
        });

        setVisible(true);
    }

    private void initApplication(GameCanvas canvas) {
        bg = new Background(canvas);
        for (int i = 0; i < sprite.length; i++) {
            sprite[i] = new Ball();
        }
    }
    public void onDrownFrame(GameCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(GameCanvas canvas, float deltaTime) {
        bg.updade(canvas, deltaTime);
        for (int i = 0; i < sprite.length; i++) {
            sprite[i].updade(canvas, deltaTime);
        }
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < sprite.length; i++) {
            sprite[i].render(canvas, g);
        }
    }
}