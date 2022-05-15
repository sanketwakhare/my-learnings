import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Driver_QuickSort {

    public static void main(String[] args) {
        Driver_QuickSort t1 = new Driver_QuickSort();
        System.out.println("Quick Sort using Threads");
        {
            List<Integer> list1 = Arrays.asList(19, 21, 13, 8, 4, 6, 35, 9, 11);
            t1.quickSort(list1);
        }
        {
            List<Integer> list1 = Arrays.asList(34, 22, 15, 13, 17, 14, 63, 55, 12, 40);
            t1.quickSort(list1);
        }

    }

    public void quickSort(List<Integer> list) {
        System.out.println("Original array: " + list);
        QuickSorter sorter = new QuickSorter(list);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<List<Integer>> futureResult = executor.submit(sorter);

        List<Integer> result = null;
        try {
            result = futureResult.get();
            System.out.println("Sorted array: " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
