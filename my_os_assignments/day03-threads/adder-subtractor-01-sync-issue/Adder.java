public class Adder implements Runnable {

    Counter counter;

    public Adder(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            this.counter.value += 1;
        }
    }

}
