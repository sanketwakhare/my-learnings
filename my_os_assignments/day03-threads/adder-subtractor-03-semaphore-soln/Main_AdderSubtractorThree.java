import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

/* Resolve Synchronization Issue with Mutex/Semaphore lock over Critical Section */
public class Main_AdderSubtractorThree {
    public static void main(String[] args) {

        CounterThree counter = new CounterThree();
        // mutex lock, when count is 1 it is mutex
        Semaphore semaphore = new Semaphore(1);
        AdderThree adder = new AdderThree(counter, semaphore);
        SubtractorThree subtractor = new SubtractorThree(counter, semaphore);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<?> adderFuture = executor.submit(adder);
        Future<?> subtractorFuture = executor.submit(subtractor);

        try {
            adderFuture.get();
            subtractorFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("Counter value: " + counter.getValue());
        executor.shutdown();
    }
}
