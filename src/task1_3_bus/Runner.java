package task1_3_bus;

import task1_3_bus.Database.Buses;

public class Runner {
    public static void main(String[] args) {

        Buses buses = new Buses();
        MenuBuses menu = new MenuBuses(buses);
        menu.showMenu();
    }
}
