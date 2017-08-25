package task5_1_2;

public class Temp {
    private int value = 0;
    private final int finalAmount = 100_000;
    boolean isAllowed = false;

    synchronized public void count(int number) {
        while (isAllowed)
            try { wait();
            } catch (InterruptedException e) {
            System.out.println(e);
        }
        this.value = number;
        System.out.println("Count: " + value);
        isAllowed = true; notify();
    }

    synchronized public int print() {
        while ( !isAllowed)
            try { wait();
            } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Print: " + value);
        isAllowed = false; notify();
        return value;
    }

    public int getValue() {
        return value;
    }

    public int getFinalAmount() {
        return finalAmount;
    }
}
