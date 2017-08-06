import java.lang.reflect.Field;
import java.util.Scanner;

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
