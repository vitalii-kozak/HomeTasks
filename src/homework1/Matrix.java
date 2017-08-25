package homework1;

import java.util.Arrays;

//2.1. Напишите консольное приложение, которое обрабатывает
//        квадратную матрицу согласно варианта (таблица 1).
//        ТРЕБОВАНИЯ.
//        1. Приложение должно быть написано на языке Java.
//        2. Использовать только стандартные компиляторы и библиотеки.
//        3. При кодировании должны быть использованы соглашения об
//        оформлении кода для языка Java.
//        4. Значения элементов матрицы задаются с помощью генератора
//        случайных чисел. Матрица должна содержать как положительные, так
//        и отрицательные значения.
//        5. Дополнительные данные (при необходимости) для обработки матрицы
//        тоже задаются генератором случайных чисел.
//        6. Для проверки результата работы нужно вывести матрицу исходную и
//        после обработки.
//   Переставьте элементы матрицы таким образом, чтобы элементы с нулевым значением размещались после всех других


public class Matrix {
    public static void main(String[] args) {

        int[][] arr2 = new int[][]{
                {1, 2, 3, 0, 0},
                {1, 2, 3, 0, 7},
                {0, 2, 0, 0, 3},
                {0, 0, 1, 2, 3},
                {1, 2, 0, 0, 3}};

        int[][] arr = new int[5][5];

        fillArrayByRandom(arr);
        printDoubleArray(arr);

        moveDoubleArray(arr);

        System.out.println("New Matrix ");
        printDoubleArray(arr);
    }

    private static int[] moveArray(int[] array) {
        int[] newArray = new int[array.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = 0;
        }
        int j=0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                newArray[j++] = array[i];
            }
        }
        return newArray;
    }

    private static void moveDoubleArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = moveArray(array[i]);
        }
    }

    private static void printDoubleArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    public static void fillArrayByRandom(int[][] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = (int) ((Math.random() * 10)) - 5;
            }
        }
    }
}