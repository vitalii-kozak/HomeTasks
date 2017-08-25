package task5_1_1;

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
