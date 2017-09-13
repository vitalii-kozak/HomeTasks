package tools;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileParser {
    public static int parseFile(String fileName, String wordForSearch) {
        Scanner scanner;
        int count = 0;
        try {
            //create new scanner for file
            scanner = new Scanner(new FileReader(fileName));

            //set delimiter - all symbols except english letters
            // Словом считается последовательность, в которой только латинские буквы
            scanner.useDelimiter("[^a-zA-Z]+");

            //for each word in file
            while (scanner.hasNext()) {
                //convert word to lower case for checking
                String word = scanner.next().toLowerCase();
                //String word = scanner.next();
                if (word.equals(wordForSearch) == true) {
                    count++;
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error File not found " + e);
        }
        return count;
    }
}
