import java.util.concurrent.Semaphore;

public class AdderThree implements Runnable {

    private CounterThree counter;
    private Semaphore semaphore;

    public AdderThree(CounterThree counter, Semaphore semaphore) {
        this.counter = counter;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {

            try {
                semaphore.acquire();

                // Peterson's solution
                this.counter.setFlag(true, 0);
                this.counter.setTurn(1);

                while (this.counter.getTurn() == 1 && this.counter.getFlag(1)) {
                }

                // Critical Section
                this.counter.setValue(this.counter.getValue() + 1);

                // reset flag
                this.counter.setFlag(false, 0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }

}
