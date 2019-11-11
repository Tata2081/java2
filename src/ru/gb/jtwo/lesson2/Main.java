package ru.gb.jtwo.lesson2;

import javafx.scene.chart.ScatterChart;

import javax.management.RuntimeErrorException;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    private static final  class RowExcessException extends RuntimeException {
        RowExcessException(String message){super("Не соответсвует кол-во строк: " + message);}
    }

    private static final  class ColumnExcessException extends RuntimeException {
        ColumnExcessException(String message){super("Не соответствует кол-во столбв: " + message);}
    }

    private static final  class StringIsNotNuberException extends RuntimeException {
        StringIsNotNuberException(String message){super("Преданное значение не является числом: " + message);}
    }

    private static final int MAX_ROW = 4;
    private static final int MAX_COLUMN = 4;

    private static final String Test_String = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 20";


    public static void main(String[] args) {
        String[][] array1 = castSrtingToArray(Test_String);
        System.out.println(Arrays.deepToString(array1));
        float res = sumAndDiv(array1);
        System.out.println("Результат задания 2 = " + res);
    }

    private static String[][] castSrtingToArray(String s){
        String[] s1 = s.split("\n");
        if (s1.length != MAX_ROW) {
            throw new RowExcessException(s1.length + ":\n" + s);
        }

        String[][] result = new String[MAX_ROW][];
        for (int i=0; i<s1.length; i++){
            result[i] = s1[i].split(" ");
            if (result[i].length != MAX_COLUMN) {
                throw new ColumnExcessException(result[i].length + ":\n" + s);
            }
        }
        return result;
    }


    private static float sumAndDiv(String[][] array1) throws NumberFormatException{
        float result = 0;
        for (int i=0; i < array1.length; i++){
            for (int j = 0; j < array1[i].length; j++){
                try {
                    result += Integer.parseInt(array1[i][j]);
                } catch (NumberFormatException e) {
                    throw new StringIsNotNuberException(array1[i][j]);
                }
            }
        }
        return (result / 2);
    }

}


