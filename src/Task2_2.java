import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//2.1. Напишите консольное приложение, которое:
//        - вводит регулярное выражение согласно варианту (таблица 2);
//        - вводит некоторую строку и определяет наличие в ней слова
//        соответствующего регулярному выражению.
//        Предусмотреть ввод произвольного количества (нескольких) строк.
//        ТРЕБОВАНИЯ.
//        1. Приложение должно быть написано на языке Java.
//        2. Использовать только стандартные компиляторы и библиотеки.
//        3. При кодировании должны быть использованы соглашения об
//        оформлении кода для языка Java.
//        4. Оформите работу со строкой в отдельном классе.
//        5. Результат проверки вывести в консоль:
//        – если соответствия найдены, то вывести их все;
//        – если соответствия найдены, то вывести соответствующее
//        сообщение.
//     Слово состоит из двух частей, которые разделены символом «*», каждая часть
//    содержит последовательность символов «A÷Z», которая обязательно начинается и заканчивается символом «^»

public class Task2_2 {
    public static void main(String args[]) {

        String text = "^AA^*^AA^ ^bb^1^bb^ By default, SB Emulation. ^BB^*^BB^ - tutorial abbyy.^CC^*^CC^ ^DD^*^DD^";

        System.out.println("Enter your text");
        text = readText();
        System.out.println();

        String[] res = text.split("\\s*(\\s|,|!|\\.)\\s*");
        int firstFound = 0;
        for (int i = 0; i < res.length; i++) {
            if (checkWithRegExp((res[i]))) {
                if (firstFound==0){
                    firstFound = 1;
                    System.out.println("We found next words: ");
                }
                System.out.println(res[i]);
            }
        }
    }

    public static boolean checkWithRegExp(String word) {
        Pattern p = Pattern.compile("\\^[A-Z]+\\^\\*\\^[A-Z]+\\^");
        Matcher m = p.matcher(word);
        return m.matches();
    }

    private static String readText() {
        StringJoiner joiner = new StringJoiner("\n");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        System.out.println("Enter the string line. Type stop for exit");

        do {
            try {
                line = reader.readLine();
                joiner.add(line);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        while (!line.toLowerCase().equals("stop"));

        return joiner.toString();
    }
}
