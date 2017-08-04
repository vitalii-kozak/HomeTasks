package HomeWork1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Numbers {
    public static void main(String[] args) {
        int number;
        do {
            System.out.println("Enter the number");
            number = readInt();
        } while (!isNumberCorrect(number));

        System.out.println("Your number is " + number);
        System.out.println("HEX " + convertToHex(number));
        System.out.println("Binary " + convertToBinary(number));
        System.out.println("Octal " + convertToOctal(number));
    }

    private static int readInt() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = reader.readLine();
            int choice = Integer.parseInt(line);
            return choice;
        } catch (NumberFormatException e) {
            System.out.println("ERROR NOT a CORRECT INT NUMBER: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private static boolean isNumberCorrect(int number) {
        if (number > 0) {
            return true;
        }
        System.out.println("Your number is an incorrect");
        return false;
    }

    public static String convertToBinary(int number) {
        String result = "";
        if (number == 0) result = 0 + result;
        while (number > 0) {
            result = (number % 2) + result;
            number = number / 2;
        }
        return result;
    }

    public static String convertToOctal(int number) {
        String result = "";
        if (number == 0) result = 0 + result;
        while (number > 0) {
            result = (number % 8) + result;
            number = number / 8;
        }
        return result;
    }

    public static String convertToHex(int number) {
        String result = "";
        if (number == 0) result = 0 + result;
        while (number > 0) {
            switch (number % 16) {
                case 10:
                    result = 'A' + result;
                    break;
                case 11:
                    result = 'B' + result;
                    break;
                case 12:
                    result = 'C' + result;
                    break;
                case 13:
                    result = 'D' + result;
                    break;
                case 14:
                    result = 'E' + result;
                    break;
                case 15:
                    result = 'F' + result;
                    break;
                default:
                    result = (number % 16) + result;
                    break;
            }
            number = number / 16;
        }
        return result;
    }

}
