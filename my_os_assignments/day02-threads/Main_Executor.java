import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main_Executor {

    public static void main(String[] args) {
        // ExecutorService es = Executors.newSingleThreadExecutor();
        // for (int i = 1; i <= 100; i++) {
        // NumberPrinter np = new NumberPrinter(i);
        // es.submit(np);
        // }

        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 1; i <= 100; i++) {
            NumberPrinter np = new NumberPrinter(i);
            es.submit(np);
        }
    }

}
