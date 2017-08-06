package task4_4_1;

public class Runner {
    public static void main(String[] args) {
        double a = 2;
        double b = 2;
        double c = 2; //уравнение
        Points points = new Points();
        Menu menu = new Menu(points, a, b, c);
        menu.showMenu();
    }
}
