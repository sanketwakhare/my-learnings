
public class AdderTwo implements Runnable {

    private CounterTwo counter;

    public AdderTwo(CounterTwo counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {

            // Peterson's solution
            this.counter.setFlag(true, 0);
            this.counter.setTurn(1);

            while (this.counter.getTurn() == 1 && this.counter.getFlag(1)) {
            }

            // Critical Section
            this.counter.setValue(this.counter.getValue() + 1);

            // reset flag
            this.counter.setFlag(false, 0);
        }
    }

}
