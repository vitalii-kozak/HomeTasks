package task5_1_1;

//1.1. Напишите консольное приложение, которое:
//        - описывает простой поток для отсчета и вывода в консоль чисел от 10 до
//        нуля с задержкой в 1 секунду, в конце выводит строку "Bomb";
//        - создает и запускает описанный поток на исполнение.
//        ТРЕБОВАНИЯ.
//        1. Приложение должно быть написано на языке Java.
//        2. Использовать только стандартные компиляторы и библиотеки.
//        3. При кодировании должны быть использованы соглашения об
//        оформлении кода для языка Java.
//        4. Поток реализуйте через анонимный класс.

public class Task_5_1_1 {
    public static void main(String[] args) {

        Thread task = new Thread() {
            public void run() {
                for (int i = 10; i >= 0; i--) {
                    System.out.println("Thread:" + getName() + " " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Bomb");
            }
        };

        task.start();
    }
}
