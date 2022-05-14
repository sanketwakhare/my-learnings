import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* Synchronization Issue when adder and subtractor are using shared data */
public class Main_AdderSubtractorTwo {
    public static void main(String[] args) {

        CounterTwo counter = new CounterTwo();
        AdderTwo adder = new AdderTwo(counter);
        SubtractorTwo subtractor = new SubtractorTwo(counter);

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
