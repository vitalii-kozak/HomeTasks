package homework1;

import java.util.Arrays;

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