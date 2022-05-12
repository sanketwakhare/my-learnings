import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* Use Callable as need to return the list of integers */
public class MergeSorter implements Callable<List<Integer>> {

    List<Integer> numbers;

    // constructor to accept input array
    public MergeSorter(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> call() throws Exception {

        // base conditions
        if (numbers.size() == 0) {
            return new ArrayList<Integer>();
        }
        if (numbers.size() == 1) {
            return new ArrayList<Integer>(this.numbers);
        }

        // create leftArray, rightArray and result list
        List<Integer> result = new ArrayList<Integer>();
        List<Integer> leftArray = new ArrayList<Integer>();
        List<Integer> rightArray = new ArrayList<Integer>();

        int n = numbers.size();
        int mid = n / 2;

        for (int i = 0; i < mid; i++) {
            leftArray.add(numbers.get(i));
        }
        for (int i = mid; i < n; i++) {
            rightArray.add(numbers.get(i));
        }

        MergeSorter leftArraySorter = new MergeSorter(leftArray);
        MergeSorter rightArraySorter = new MergeSorter(rightArray);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<List<Integer>> leftSortedFuture = executor.submit(leftArraySorter);
        Future<List<Integer>> rightSortedFuture = executor.submit(rightArraySorter);

        List<Integer> leftSorted = leftSortedFuture.get();
        List<Integer> rightSorted = rightSortedFuture.get();

        // shutdown the executor
        executor.shutdown();

        int i = 0;
        int j = 0;
        while (i < leftSorted.size() && j < rightSorted.size()) {
            if (leftSorted.get(i) <= rightSorted.get(j)) {
                result.add(leftSorted.get(i));
                i++;
            } else if (leftSorted.get(i) > rightSorted.get(j)) {
                result.add(rightSorted.get(j));
                j++;
            }
        }

        while (i < leftSorted.size()) {
            result.add(leftSorted.get(i));
            i++;
        }

        while (j < rightSorted.size()) {
            result.add(rightSorted.get(j));
            j++;
        }
        return result;
    }

}
