package task1_3_bus.Query;



import task1_3_bus.Database.Buses;

import java.util.StringJoiner;

public class QueryList {

    public static String sortByYears(Buses buses, int year) {
        StringJoiner joiner = new StringJoiner("\n");
        for (int i = 0; i < buses.getSize(); i++) {
            if (buses.get(i).getStartYear() < year) {
                joiner.add(buses.get(i).toString());
            }
        }
        return "Buses sort by year:\n" + joiner.toString();
    }

    public static String sortByRoute(Buses buses, int routeNumber) {
        StringJoiner joiner = new StringJoiner("\n");
        for (int i = 0; i < buses.getSize(); i++) {
            if (buses.get(i).getRouteNumber() < routeNumber) {
                joiner.add(buses.get(i).toString());
            }
        }
        return "Buses sort by route number:\n" + joiner.toString();
    }

    public static String sortByDistance(Buses buses, double distance) {
        StringJoiner joiner = new StringJoiner("\n");
        for (int i = 0; i < buses.getSize(); i++) {
            if (buses.get(i).getDistance() > distance) {
                joiner.add(buses.get(i).toString());
            }
        }
        return "Buses sort by distance:\n" + joiner.toString();
    }
}
