package Task1_3_Bus.View;

import Task1_3_Bus.Entity.Bus;

import java.util.Comparator;

public class SortByDistance implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        double distance1 = ((Bus) o1).getDistance();
        double distance2 = ((Bus) o2).getDistance();

        if (distance1 > distance2) return 1;
        if (distance1 < distance2) return -1;
        return 0;

    }
}
