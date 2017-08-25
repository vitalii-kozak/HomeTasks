package task4_3_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
