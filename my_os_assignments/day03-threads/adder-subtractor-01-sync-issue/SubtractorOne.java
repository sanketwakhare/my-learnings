public class SubtractorOne implements Runnable {

    CounterOne counter;

    public SubtractorOne(CounterOne counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            this.counter.value -= 1;
        }
    }
}
