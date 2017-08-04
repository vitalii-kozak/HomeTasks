package Task1_3_Bus;

import Task1_3_Bus.Database.Buses;
import Task1_3_Bus.Entity.Bus;
import Task1_3_Bus.Entity.Driver;
import Task1_3_Bus.Query.QueryList;
import Task1_3_Bus.View.BusesSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

abstract class MenuEntry {
    private String title;

    public MenuEntry(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public abstract void run();
}

class MenuBuses {
    private static final String MENU_PATTERN = "%s - %s\n";
    private List<MenuEntry> entries = new ArrayList<MenuEntry>();
    private boolean isExit = false;
    private boolean allowPurchase = false;
    private boolean allowAdd = false;


    public MenuBuses(Buses buses) {


        entries.add(new MenuEntry("Generate list of Buses") {
            @Override
            public void run() {
                System.out.println("Generate list of Buses");
                Driver driver1 = new Driver("Sonny","Landham");
                Driver driver2 = new Driver("Arnold", "Schwarzenegger");
                Driver driver3 = new Driver("Carl", "Weathers");
                Driver driver4 = new Driver("Bill","Duke");

                Bus bus1 = new Bus(driver1, 10000,2007, "AA1987AA", 18, "Icarus");
                Bus bus2 = new Bus(driver2, 20000,2008, "AA1988AA", 18, "Icarus");
                Bus bus3 = new Bus(driver3, 30000,2009, "AA1989AA", 20, "Icarus");
                Bus bus4 = new Bus(driver4, 40000,2010, "AA1990AA", 18, "Icarus");
                Bus bus5 = new Bus(driver1, 10000,2001, "AA1981AA", 18, "Icarus");
                Bus bus6 = new Bus(driver2, 20000,2002, "AA1982AA", 18, "Icarus");
                Bus bus7 = new Bus(driver3, 30000,2003, "AA1983AA", 20, "Icarus");

                buses.add(bus1);
                buses.add(bus2);
                buses.add(bus3);
                buses.add(bus4);
                buses.add(bus5);
                buses.add(bus6);
                buses.add(bus7);
                buses.add(buses.generateBus());
                buses.add(buses.generateBus());
                buses.add(buses.generateBus());
            }
        });

        entries.add(new MenuEntry("Print list of Bases") {
            @Override
            public void run() {
                System.out.println("List of Bases");
                System.out.println(buses);

            }
        });

        entries.add(new MenuEntry("Print buses by year") {
            @Override
            public void run() {
                System.out.println("List of buses by year");
                System.out.println(QueryList.sortByYears(buses, 2007));
            }
        });

        entries.add(new MenuEntry("Print buses by route") {
            @Override
            public void run() {
                System.out.println("List of buses by route");
                System.out.println(QueryList.sortByRoute(buses, 20));
            }
        });

        entries.add(new MenuEntry("Print buses by distance") {
            @Override
            public void run() {
                System.out.println("List of buses by distance");
                System.out.println(QueryList.sortByDistance(buses, 10000));
            }
        });

        entries.add(new MenuEntry("Sort By Distance") {
            @Override
            public void run() {
                System.out.println("Sort By Distance");
                BusesSort.sortFlightsByTime(buses.returnArray());

            }
        });

        entries.add(new MenuEntry("Exit") {
            @Override
            public void run() {
                isExit = true;
            }
        });
    }


    public void showMenu() {
        while (!isExit) {
            printMenu();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                String line = reader.readLine();
                int choice = Integer.parseInt(line);
                if ((choice <= 0) || (choice - 1 >= entries.size())) {
                    System.out.println("ERROR WRONG MENU INDEX: ");
                } else {
                    MenuEntry entry = entries.get(choice - 1);
                    entry.run();
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR NOT a NUMBER: " + e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public MenuBuses addEntry(MenuEntry entry) {
        int index = entries.size() - 1;
        entries.add(index, entry);
        return this;
    }

    private void printMenu() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("\nMenu:\n");
        for (int i = 0; i < entries.size(); i++) {
            MenuEntry entry = entries.get(i);
            String entryFormatted = String.format(MENU_PATTERN, (i + 1), entry.getTitle());
            buffer.append(entryFormatted);
        }
        System.out.print(buffer.toString());
    }
}


