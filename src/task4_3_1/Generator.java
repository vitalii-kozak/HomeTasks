package task4_3_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//3.1. Напишите консольное приложение, которое:
//        - описывает класс, который является генератором списка (List) и
//        множества (Set) из указанного количества и диапазона;
//        - создает по одному экземпляру списка и множества, а затем отображает
//        их в консоль.
//        ТРЕБОВАНИЯ.
//        1. Приложение должно быть написано на языке Java.
//        2. Использовать только стандартные компиляторы и библиотеки.
//        3. При кодировании должны быть использованы соглашения об
//        оформлении кода для языка Java.
//        4. Все данные должны быть введены набором на клавиатуре.

public class Generator {

    public static void main(String[] args) {
        int min = -50;
        int max = 100;
        int count = 10;

        System.out.println("List: " + generateList(count, max, min));
        System.out.println("Set:  "+ generateSet(count, max, min));
    }

    public static List<Integer> generateList(int count, int max, int min) {
        List<Integer> list = new ArrayList<>();
        max -= min;
        for (int i = 0; i < count; i++) {
            list.add((int) (Math.random() * ++max) + min);
       }
        return list;
    }

    public static Set<Integer> generateSet(int count, int max, int min) {
        Set<Integer> set = new HashSet<>();
        max -= min;
        while(set.size() < count) {
            set.add((int) (Math.random() * ++max) + min);
        }

        return set;
    }
}
