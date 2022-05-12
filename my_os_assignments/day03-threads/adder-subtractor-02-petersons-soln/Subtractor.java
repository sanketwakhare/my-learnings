public class Subtractor implements Runnable {

    Counter counter;

    public Subtractor(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            // Peterson's solution
            this.counter.flag[1] = true;
            this.counter.turn = 0;

            while (this.counter.turn == 0 && this.counter.flag[0]) {
            }

            // Critical Section
            this.counter.value -= 1;

            // reset flag
            this.counter.flag[1] = false;
        }
    }
}
