package task3_1;

import task3_1.Data.Calendar;
import task3_1.Menu.Menu;

public class Runner {
    public static void main(String[] args) {

        Calendar days = new Calendar();
        Menu menu = new Menu(days);
        menu.showMenu();
    }
}
