import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Thread> allThreads = new ArrayList<Thread>();
        for (int i = 1; i <= 100; i++) {
            NumberPrinter np = new NumberPrinter(i);
            Thread t = new Thread(np);
            allThreads.add(t);
            t.start();
        }
        for (int i = 0; i < 100; i++) {
            try {
                // wait for current threads to complete
                allThreads.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finished");
    }

}
