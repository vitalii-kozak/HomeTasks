package homework1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PerfectNumbers {
    public static void main(String[] args) {
        int number;
        do {
            System.out.println("Enter the number");
            number = readInt();
        } while (!isNumberCorrect(number));

        for (int i = 1; i <= number; i++) {
            if (isPerfect(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isPerfect(int number) {
        int sum = 0;

        for (int i = number / 2; i >= 1; --i)
            if (number % i == 0)
                sum += i;

        return sum == number;
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
        if (number > 0) {
            return true;
        }
        System.out.println("Your number is an incorrect");
        return false;
    }
}
