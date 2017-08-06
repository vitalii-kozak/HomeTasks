package homework1;

import java.util.Arrays;

public class Matrix2 {
    public static void main(String[] args) {

        int[][] arr = new int[][]{
                {1, 2, 3, 0, 0},
                {1, 2, 3, 0, 7},
                {0, 2, 0, 0, 3},
                {0, 0, 1, 2, 3},
                {1, 2, 0, 0, 3}};


        fillArrayByRandom(arr);
        printDoubleArray(arr);

        zeroesToTheEnd(arr);

        System.out.println();
        printDoubleArray(arr);

    }

    public static void zeroesToTheEnd(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] == 0) { //находим 0, а потом меняем его с ближайшим не 0
                    for (int i1 = i; i1 < array.length; i1++) {
                        boolean found = false;
                        int index = 0;
                        if (i1==i) {
                            index = j;
                        }

                        for (int j1=index; j1 < array.length; j1++) {
                            if (array[i1][j1] != 0) { //нашли ближайший не 0. Меняем. Больше искать не надо поэтому прирываем
                                array[i][j] = array[i1][j1];
                                array[i1][j1] = 0;
                                found = true;
                                break;
                            }
                        }
                        if (found) {
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void printDoubleArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    public static void fillArrayByRandom(int[][] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = (int) ((Math.random() * 5)) - 2;
            }
        }
    }
}
