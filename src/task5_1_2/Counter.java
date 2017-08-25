package task5_1_2;

class Counter implements Runnable {
    Temp temp;
    Counter(Temp temp) {
        this.temp = temp;
        new Thread(this, "Counter").start();
    }
    public void run() {
        while (temp.getValue() < temp.getFinalAmount()) {
            temp.count(temp.getValue()+1);
        }
    }

}
