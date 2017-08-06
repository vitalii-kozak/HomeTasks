package task1_3_bus.Database;

import task1_3_bus.Entity.Bus;
import task1_3_bus.Entity.Driver;

import java.util.StringJoiner;

public class Buses {
    private Bus[] buses = new Bus[5];
    private int size = 0;

    public void add(Bus bus) {
        if (buses.length > size) {
            buses[size++] = bus;
        } else {
            buses = increaseArray(buses);
            buses[size++] = bus;
        }
    }
    public Bus get(int index) {
        return buses[index];
    }

    private Bus[] increaseArray(Bus[] buses) {
        int newSize = (int) (size * 1.5 + 1);
        Bus[] newBuses = new Bus[newSize];
        for (int i = 0; i < size; i++) {
            newBuses[i] = buses[i];
        }
        return newBuses;
    }

    public Bus[] returnArray() {
        Bus[] newBuses = new Bus[size];
        for (int i = 0; i < size; i++) {
            newBuses[i] = buses[i];
        }
        return newBuses;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        for (int i = 0; i < size; i++) {
            joiner.add(buses[i].toString());
        }
        return "Buses:\n" + joiner.toString();
    }

    public Bus generateBus(){

        Database db = new Database();

        //случайный водитель
        int randomSelection = (int) (Math.random() * db.namesOfDrivers.length);
        Driver driver = db.namesOfDrivers[randomSelection];

        //случайная марка
        randomSelection = (int) (Math.random() * db.namesOfBusMarks.length);
        String BusMark = db.namesOfBusMarks[randomSelection];

        //случайный номер автобуса
        randomSelection = (int) (Math.random() * db.busesNumbers.length);
        String busNumber = db.busesNumbers[randomSelection];

        //случайный номер маршрута
        randomSelection = (int) (Math.random() * db.routesNumbers.length);
        int routeNumber = db.routesNumbers[randomSelection];

        return new Bus(driver, ((double) (Math.random() * 10  * 3000)),((int) (Math.random() * 10 + 2000)), busNumber, routeNumber, BusMark);
    }
}
