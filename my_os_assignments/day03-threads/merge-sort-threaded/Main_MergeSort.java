import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main_MergeSort {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(19, 21, 13, 8, 4, 6, 35, 9, 11);
        System.out.println("Original array: " + list);
        MergeSorter sorter = new MergeSorter(list);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<List<Integer>> futureResult = executor.submit(sorter);

        try {
            List<Integer> result = futureResult.get();
            System.out.println("Sorted array: " + result);
            executor.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
