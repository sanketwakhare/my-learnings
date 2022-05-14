import java.util.concurrent.Semaphore;

public class SubtractorThree implements Runnable {

    private CounterThree counter;
    private Semaphore semaphore;

    public SubtractorThree(CounterThree counter, Semaphore semaphore) {
        this.counter = counter;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {

            try {
                semaphore.acquire();
                // Peterson's solution
                this.counter.setFlag(true, 1);
                this.counter.setTurn(0);

                while (this.counter.getTurn() == 0 && this.counter.getFlag(0)) {
                }

                // Critical Section
                this.counter.setValue(this.counter.getValue() - 1);

                // reset flag
                this.counter.setFlag(false, 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }
}
