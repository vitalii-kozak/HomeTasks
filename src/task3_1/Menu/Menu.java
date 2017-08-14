package task3_1.Menu;

import task3_1.Data.Calendar;
import task3_1.Tools.CalendarStore;

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

public class Menu {
    private static final String MENU_PATTERN = "%s - %s\n";
    private List<MenuEntry> entries = new ArrayList<MenuEntry>();
    private boolean isExit = false;
    private boolean allowPurchase = false;
    private boolean allowAdd = false;

    public Menu(Calendar days) {


        entries.add(new MenuEntry("Fill the days") {
            @Override
            public void run() {
                System.out.println("Fill the days");
                days.fillTheCalendar();
            }
        });

        entries.add(new MenuEntry("Print all holidays") {
            @Override
            public void run() {
                System.out.println("Print all holidays");
                System.out.println(days.findAllHolidays());
            }
        });

        entries.add(new MenuEntry("Print all church holidays") {
            @Override
            public void run() {
                System.out.println("church holidays are ");
                System.out.println(days.findAllChurchHolidays());
            }
        });

        entries.add(new MenuEntry("Export to file") {
            @Override
            public void run() {
                System.out.println("Export to file");
                if (CalendarStore.exportToFile("Calendar.ser", days)){
                    System.out.println("Success");
                }else{
                    System.out.println("Fail");
                }

            }
        });

        entries.add(new MenuEntry("Import from file") {
            @Override
            public void run() {
                System.out.println("Import from file");
                System.out.println(CalendarStore.importFromFile("Calendar.ser"));

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

    public Menu addEntry(MenuEntry entry) {
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
