package task5_1_2;

class Printer implements Runnable {
    Temp temp;

    Printer(Temp temp) {
        this.temp = temp;
        new Thread(this, "Printer").start();
    }

    public void run() {
        while (temp.getValue() < temp.getFinalAmount()) {
            temp.print();
        }
    }
}
