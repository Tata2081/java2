package ru.gb.jtwo.lesson2;

import javafx.scene.chart.ScatterChart;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        String s = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";

        String[][] array1 = new String[4][4];
        float res;

        try {
            array1 = castSrtingToArray(s);
            printArray(array1);
            try {
                res = sumAndDiv(array1);
                System.out.println("Результат задания 2 = " + res);
            } catch (NumberFormatException e) {
                System.out.println("В массиве не все указанные значения числа! Получение результата не возможно!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Количестко элементов в строке, разделенных спец символами, не соответсвует матрице 4x4");
        }
    }

    private static String[][] castSrtingToArray(String s) throws ArrayIndexOutOfBoundsException{
        String[][] strArray = new String[4][4];


        for (int i=0; i<4; i++){
            String s1 = s.split("\n")[i];
            for (int j=0; j<4; j++){
                strArray[i][j] = s1.split(" ")[j];
            }
        }
        return   strArray;
    }

    private static void printArray(String[][] array1){
        for (int i=0; i<array1.length; i++) {
            for (int j=0; j<array1[i].length; j++){
                System.out.print(array1[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private static float sumAndDiv(String[][] array1) throws NumberFormatException{
        float result = 0;
        for (int i=0; i < array1.length; i++){
            for (int j = 0; j < array1[i].length; j++){
                result += Integer.parseInt(array1[i][j]);
            }
        }
        return (result / 2);
    }

}


