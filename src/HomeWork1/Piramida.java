package HomeWork1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
