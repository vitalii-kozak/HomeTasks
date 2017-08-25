package task5_1_2;

public class Runner {
    public static void main(String[] args) {
        Temp temp = new Temp();
        System.out.println("Запуск двух синхронизированных потоков");
        new Counter(temp);
        new Printer(temp);
    }
}
