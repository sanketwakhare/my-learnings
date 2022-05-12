import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* Synchronization Issue when adder and subtractor are using shared data */
public class Main_AdderSubtractor {
    public static void main(String[] args) {
        System.out.println("Adder Subtractor Synchronization");

        Counter counter = new Counter();
        Adder adder = new Adder(counter);
        Subtractor subtractor = new Subtractor(counter);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<?> adderFuture = executor.submit(adder);
        Future<?> subtractorFuture = executor.submit(subtractor);

        try {
            adderFuture.get();
            subtractorFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println(counter.value);
        executor.shutdown();
    }
}
