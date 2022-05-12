public class Adder implements Runnable {

    Counter counter;

    public Adder(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            // Peterson's solution
            this.counter.flag[0] = true;
            this.counter.turn = 1;

            while (this.counter.turn == 1 && this.counter.flag[1]) {
            }

            // Critical Section
            this.counter.value += 1;

            // reset flag
            this.counter.flag[0] = false;
        }
    }

}
