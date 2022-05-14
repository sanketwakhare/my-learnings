public class SubtractorTwo implements Runnable {

    CounterTwo counter;

    public SubtractorTwo(CounterTwo counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {

            // Peterson's solution
            this.counter.setFlag(true, 1);
            this.counter.setTurn(0);

            while (this.counter.getTurn() == 0 && this.counter.getFlag(0)) {
            }

            // Critical Section
            this.counter.setValue(this.counter.getValue() - 1);

            // reset flag
            this.counter.setFlag(false, 1);
        }
    }
}
