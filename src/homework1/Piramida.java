package homework1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1.3. Напишите консольное приложение, которое вызывает метод для
//        построения пирамиды высотой в диапазоне от 1 по 9. Например, для высоты
//        = 4:
//           1
//          121
//         12321
//        1234321
//        ТРЕБОВАНИЯ.
//        1. Приложение должно быть написано на языке Java.
//        2. Использовать только стандартные компиляторы и библиотеки
//        (java.lang).
//        3. При кодировании должны быть использованы соглашения об
//        оформлении кода для языка Java.

public class Piramida {
    public static void main(String[] args) {
        int number;
        do {
            System.out.println("Enter the number");
            number = readInt();
        } while (!isNumberCorrect(number));
        for (int i = 1; i <= number ; i++) {
            drawPiramidaLine(i,number);
        }

    }

    private static void drawPiramidaLine(int number,int deep) {
        for (int i = 0; i < deep - number ; i++) {
            System.out.print(" ");
        }
        for (int i = 1; i <= number ; i++) {
            System.out.print(i);
        }
        for (int i = number-1; i >= 1 ; i--) {
            System.out.print(i);
        }
        System.out.println();
    }

    private static int readInt() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choice = 0;
        try {
            String line = reader.readLine();
            choice = Integer.parseInt(line);
            return choice;
        } catch (NumberFormatException e) {
            System.out.println("ERROR NOT a CORRECT INT NUMBER: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return choice;
    }

    private static boolean isNumberCorrect(int number) {
        if ((number >= 1)&&(number <= 9)) {
            return true;
        }
        System.out.println("Your number is an incorrect");
        return false;
    }
}
