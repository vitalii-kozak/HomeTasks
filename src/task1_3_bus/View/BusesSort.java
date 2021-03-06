package task1_3_bus.View;

import task1_3_bus.Entity.Bus;

import java.util.Arrays;

public class BusesSort {
    public static void sortFlightsByTime(Bus[] buses) {
        System.out.println(Arrays.toString(buses));
        Arrays.sort(buses, new SortByDistance());
        for (Bus bus : buses) {
            System.out.println(bus);
        }
    }
}
