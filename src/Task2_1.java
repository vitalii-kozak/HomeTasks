import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//1.1. Напишите консольное приложение, которое:
//        - читает с клавиатуры произвольный текст, состоящий из нескольких
//        предложений и строк;
//        - выполняет обработку введенного текста (изменяет этот же текст, не
//        создает новый) согласно варианта (таблица 1).
//        ТРЕБОВАНИЯ.
//        1. Приложение должно быть написано на языке Java.
//        2. Использовать только стандартные компиляторы и библиотеки.
//        3. При кодировании должны быть использованы соглашения об
//        оформлении кода для языка Java.
//        4. Оформите работу с текстом в отдельном классе.
//        5. Дополнительные данные (при необходимости) для обработки текста
//        задаются вводом с клавиатуры.
//        6. Для проверки работы текст следует вывести в консоль после
//        обработки.

//       сделайте так, чтобы каждое слово начиналось с большой буквы

public class Task2_1 {
    public static void main(String[] args) {

        String text = "Code 2 learn java tutorial abbyy. Use SBESET.EXE to manually configure SB resources or \n" +
                "    disable SB Emulation. By default, SB Emulation in DOS follows \n" +
                "    the Windows settings.";

        //Example text
        //This is a legal agreement ("Agreement") between you and Canon Inc. ("Canon") and governing your use of Canon's software programs including the related manuals or any printed material thereof (the "Software") for certain Canon's copying machines, printers and multifunctional peripherals (the "Products").

        System.out.println("Enter your text");
        text = readText();
        System.out.println();

        System.out.println(textToFirstUpper(text));

    }

    public static String textToFirstUpper(String text) {
        Pattern p = Pattern.compile("\\b");
        Matcher m = p.matcher(text);
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (m.find()) {
            String val = text.substring(index, m.start());
            index = m.start();
            sb.append(firstUpperCase(val));
        }
        sb.append(text.substring(index));
        return sb.toString();
    }

    public static String firstUpperCase(String word) {
        if (word == null || word.isEmpty()) return "";
        return word.substring(0, 1).toUpperCase() + word.substring(1);
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
