package task4_3_2;

public class Runner {
    public static void main(String[] args) {

        Dictionary dic = new Dictionary();
        MenuDictionary menu = new MenuDictionary(dic);
        menu.showMenu();
    }
}
