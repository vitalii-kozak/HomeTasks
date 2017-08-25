import java.lang.reflect.Field;
import java.util.Scanner;

//2.1. Напишите консольное приложение, которое:
//        - создает и инициализирует переменную типа String;
//        - использует рефлексию для изменения значения созданной строки ( через
//        доступ к закрытому полю char[] value класса String).
//        ТРЕБОВАНИЯ.
//        1. Приложение должно быть написано на языке Java.
//        2. Использовать только стандартные компиляторы и библиотеки.
//        3. При кодировании должны быть использованы соглашения об
//        оформлении кода для языка Java.
//        4. Строка может быть создана и проинициализирована двумя способами:
//        как строковый литерал или введена набором с клавиатуры.
//        5. Значение для замены тоже может быть заданным программно или
//        введенным набором с клавиатуры.
//        6. Строка должна быть выведена до изменения и после.

public class Task4_2_1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input first sentence:");
        String string1 = scanner.nextLine();

        System.out.print("Input second sentence:");
        String string2 = scanner.nextLine();


        System.out.println(string1 + " " + string2);
        changeString(string1, string2);
        System.out.println(string1 + " " + string2);
    }

    public static String changeString(String oldString, String newString)  {

        String result = oldString;

        try {
            Field valueField = String.class.getDeclaredField("value");
            valueField.setAccessible(true);
            valueField.set(result, newString.toCharArray());
        }catch (IllegalAccessException | NoSuchFieldException e){
            e.printStackTrace();
        }

        return result;
    }
}
