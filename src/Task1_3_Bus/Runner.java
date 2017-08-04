package Task1_3_Bus;

import Task1_3_Bus.Database.Buses;

public class Runner {
    public static void main(String[] args) {

        Buses buses = new Buses();
        MenuBuses menu = new MenuBuses(buses);
        menu.showMenu();
    }
}
